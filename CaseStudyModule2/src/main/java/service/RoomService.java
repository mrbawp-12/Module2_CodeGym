package service;

import model.Room;
import model.RoomStatus;
import utils.*;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import exception.*;

public class RoomService {
    //doc room tu file
    private List<Room> readRoomsFromFile() {
        List<Room> rooms = new ArrayList<>();
        List<String> lines = File.readFile("rooms.txt");

        for (String line : lines) {
            String[] data = line.split(",");
            if (data.length == 5) {
                rooms.add(new Room(data[0], data[1], Double.parseDouble(data[2]), Integer.parseInt(data[3]), data[4]));
            }
        }
        return rooms;
    }

    //ghi room -> file
    private void writeRoomsToFile(List<Room> rooms) {
        List<String> lines = new ArrayList<>();
        for (Room r : rooms) {
            lines.add(String.format("%s,%s,%.2f,%d,%s", r.getId(), r.getRoomName(), r.getPrice(), r.getBedCount(), r.getStatus()));
        }
        File.writeFile("rooms.txt", lines);
    }

    //lauy tat ca phong
    public List<Room> getAllRooms() {
        return readRoomsFromFile();
    }

    //tim theo gia
    public List<Room> findRoomsByPrice(double minPrice, double maxPrice) {
        return readRoomsFromFile().stream().filter(r -> r.getPrice() >= minPrice && r.getPrice() <= maxPrice).collect(Collectors.toList());
    }

    //tim theo id
    public Room findRoomById(String id) throws NotFoundException {
        return readRoomsFromFile().stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Khong tim thay phong voi ID: " + id));
    }


    //them phong
    public void addRoom(Room room) {
        List<Room> rooms = readRoomsFromFile();
        rooms.add(room);
        writeRoomsToFile(rooms);
    }

    //sua phong
    public void updateRoom(Room room) throws NotFoundException {
        List<Room> rooms = readRoomsFromFile();
        for (int i = 0; i < rooms.size(); i++) {
            if(rooms.get(i).getId().equals(room.getId())) {
                rooms.set(i, room);
                writeRoomsToFile(rooms);
                return;
            }
        }
        throw new NotFoundException("Khong tim thay phong");
    }

        //xoa phong
        // Trong RoomService.java
        public void deleteRoom(String id) throws NotFoundException {
            List<Room> rooms = readRoomsFromFile();
            boolean removed = rooms.removeIf(r -> r.getId().equals(id));
            if (!removed) {
                throw new NotFoundException("Khong tim thay phong voi ID: " + id);
            }
            writeRoomsToFile(rooms);
        }
}