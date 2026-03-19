package service;

import model.Invoice;
import utils.*;
import exception.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InvoiceService {
    //doc hoa don tu file
    private List<Invoice> readInvoicesFromFile() {
        List<Invoice> invoices = new ArrayList<>();
        List<String> lines = File.readFile("invoices.txt");

        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length == 7) {
                invoices.add(new Invoice(data[0], data[1], data[2], data[3], File.parseDate(data[4]), File.parseDate(data[5]), Double.parseDouble(data[6])));
            }
        }
        return invoices;
    }

    //ghi hoa don vao file
    private void writeInvoicesToFile(List<Invoice> invoices) {
        List<String> lines = new ArrayList<>();
        for (Invoice i : invoices) {
            lines.add(String.format("%s,%s,%s,%s,%s,%s,%.2f", i.getId(), i.getRoomName(), i.getCustomerName(), i.getEmployeeName(), File.formatDate(i.getCheckInDate()), File.formatDate(i.getCheckOutDate()), i.getTotalMoney()));
        }
        File.writeFile("invoices.txt", lines);
    }

    //lay tat ca hoa don
    public List<Invoice> getAllInvoices() {
        return readInvoicesFromFile();
    }

    //tim hoa don theo id
    public Invoice findInvoiceById(String id) throws NotFoundException {
        return readInvoicesFromFile().stream().filter(i -> i.getId().equals(id)).findFirst().orElseThrow(() -> new NotFoundException("Khong tim thay hoa don"));
    }

    //them hoa don
    public void addInvoice(Invoice invoice) {
        invoice.setId("INV" + System.currentTimeMillis());
        List<Invoice> invoices = readInvoicesFromFile();
        invoices.add(invoice);
        writeInvoicesToFile(invoices);
    }

    //tim hoa don theo ngay
    public List<Invoice> findInvoicesByDate(LocalDate date) {
        return readInvoicesFromFile().stream().filter(i -> i.getCheckInDate().equals(date) || i.getCheckOutDate().equals(date)).collect(Collectors.toList());
    }

    //sua hoa don
    public void updateInvoice(Invoice invoice) throws NotFoundException {
        List<Invoice> invoices = readInvoicesFromFile();
        for (int i = 0; i < invoices.size(); i++) {
            if (invoices.get(i).getId().equals(invoice.getId())) {
                invoices.set(i, invoice);
                writeInvoicesToFile(invoices);
                return;
            }
        }
        throw new NotFoundException("Khong tim thay hoa don de sua");
    }

    //tinh doanh thu theo thang
    public double calculateMonthlyRevenue(int month, int year) {
        return readInvoicesFromFile().stream().filter(i -> i.getCheckOutDate().getMonthValue() == month && i.getCheckOutDate().getYear() == year).mapToDouble(Invoice::getTotalMoney).sum();
    }

    //
}