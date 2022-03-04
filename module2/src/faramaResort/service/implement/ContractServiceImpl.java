package faramaResort.service.implement;

import faramaResort.controllers.FuramaController;
import faramaResort.models.agreement.Booking;
import faramaResort.models.agreement.Contract;
import faramaResort.models.person.Customer;
import faramaResort.service.IBookingContact;
import faramaResort.utils.SortByTimeBooking;

import java.io.*;
import java.util.*;

public class ContractServiceImpl implements IBookingContact {
    static ArrayDeque<Booking> bookingQueue = new ArrayDeque<>();
    static List<Contract> contractList = new ArrayList<>();
    static List<Booking> bookingList = new ArrayList<>();
    static  Scanner scanner ;
    public ContractServiceImpl(){
        contractList = readContract();
        init();
    }
    @Override
    public void add() {
        String contractIdNo;
        String bookingId;
        int deposit;
        int totalRentFee;
        String idCustomer;

        if(bookingQueue.size()>0){
            scanner = new Scanner(System.in);
            Booking booking = bookingQueue.poll();
            contractIdNo = randomIdContract();
            bookingId = booking.getBookingId();
            idCustomer = booking.getIdCustomer();
            do{
                try{
                    System.out.println("Please input deposit");
                    deposit = Integer.parseInt(scanner.nextLine());
                }catch (Exception e){
                    System.out.println("Deposit must be a number and positive");
                    continue;
                }
                if(deposit<0){
                    System.out.println("Deposit must be a number and positive");
                    continue;
                }
                break;
            }while(true);

            do{
                try{
                    System.out.println("Please input totalRentFee");
                    totalRentFee = Integer.parseInt(scanner.nextLine());
                }catch (Exception e){
                    System.out.println("total rent fee must be a number and bigger deposit");
                    continue;
                }
                if(totalRentFee<deposit){
                    System.out.println("total rent fee must be a number and bigger deposit");
                    continue;
                }
                break;
            }while(true);
            //String contractIdNo, String bookingId,
            //                    int deposit, int totalRentFee, String idCustomer
            Contract contract = new Contract(contractIdNo,bookingId,deposit,totalRentFee,idCustomer);
            contractList.add(contract);
            writeContract();
        }else {
            System.out.println("there is not booking in list. please add booking");
        }
    }

    @Override
    public void display() {
//       if(contractList.size()>0){
//           for(Contract contract : contractList){
//               System.out.println(contract);
//           }
//       }else {
//           System.out.println("this is not contract now");
//       }

        if (contractList.size() >1) {

            System.out.println();
            System.out.println(FuramaController.THUT+"List Contract");
            System.out.println();
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t-----------------------------------------------------------");
            System.out.println();
            //String contractIdNo, String bookingId,
            //                    int deposit, int totalRentFee, String idCustomer
            System.out.printf("%-55s%-12s%-12s%-10s%-12s%-14s%-12s","","|contract id",
                    "|booking id","|  deposit","| total rent","| idCustomer","|");
            System.out.println();
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t-----------------------------------------------------------");
            for(Contract contract : contractList){
                System.out.printf("%-55s%-12s%-12s%-10s%-12s%-14s%-12s"," ",
                        "| "+contract.getContractIdNo(),"| "+contract.getBookingId(),"| "+contract.getDeposit(),
                        "| "+contract.getTotalRentFee(), "| "+contract.getIdCustomer(), "|");
                System.out.println();
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t-----------------------------------------------------------");
            }
            System.out.println();

        }else {
            System.out.println(FuramaController.THUT+"(^_^_________________________(^_^)");
            System.out.println(FuramaController.THUT+"not exist data,please add new data");
            System.out.println(FuramaController.THUT+"(^_^_________________________(^_^)");
            System.out.println();
        }
    }




    public static void readBookingFromFile(){
        bookingList.clear();
        File file = new File("/Users/nguyenhoang/Desktop/codegym/C1021G1/module2/src/faramaResort/data/booking.csv");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data = null;
            while ((data=bufferedReader.readLine())!=null){
                String[] bookingArr = data.split(",");
                if(bookingArr.length == 8) {
                    Booking booking = new Booking(bookingArr[0], bookingArr[1], bookingArr[2],
                            bookingArr[3], bookingArr[4], bookingArr[5], bookingArr[6]);
                    booking.setQuantityOfBooking(Integer.parseInt(bookingArr[7]));
                    if (!booking.getServiceName().toLowerCase().contains("room")){
                        bookingList.add(booking);
                    }
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    static void initBookingQueue(){

        List<Contract> countList = readContract();
        //System.out.println("contract: "+countList.size());
       // System.out.println("bookingQuee: "+bookingQueue.size());
       // System.out.println("listBooikng: "+bookingList.size());
        int contractNum = countList.size() + bookingQueue.size();
        if(contractNum<bookingList.size()){
            for(int i = contractNum;i<bookingList.size();i++){
                bookingQueue.add(bookingList.get(i));
            }
        }
        //System.out.println("contract: "+countList.size());
       // System.out.println("bookingQuee: "+bookingQueue.size());
        //System.out.println("listBooikng: "+bookingList.size());
    }

    public void init(){
        //readBookingFromFile();
        readBookingFromFile();
        Collections.sort(bookingList,new SortByTimeBooking());
        initBookingQueue();
    }

    int random(){
        return (int)Math.floor(Math.random()*10);
    }
    String randomIdContract(){
        return "FURAMA"+random() + random() + random();
    }

    static void writeContract(){
        File file = new File("/Users/nguyenhoang/Desktop/codegym/C1021G1/module2/src/faramaResort/data/contract.csv");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(Contract contract : contractList){
                bufferedWriter.write(contract.getContractIdNo()+","+contract.getBookingId()+","+
                        contract.getDeposit()+","+contract.getTotalRentFee()+","+contract.getBookingId());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static List<Contract>  readContract(){
        List<Contract> contractArrayList= new ArrayList<>();
        File file = new File("/Users/nguyenhoang/Desktop/codegym/C1021G1/module2/src/faramaResort/data/contract.csv");
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String data = null;
            while((data = bufferedReader.readLine())!=null){
                String[] contractArray = data.split(",");
                //String contractIdNo, String bookingId,
                //                    int deposit, int totalRentFee, String idCustomer
                Contract contract = new Contract(contractArray[0],contractArray[1],Integer.parseInt(contractArray[2]),
                        Integer.parseInt(contractArray[3]),contractArray[4]);
                contractArrayList.add(contract);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contractArrayList;
    }

    public  void editContract(){
        scanner = new Scanner(System.in);
        String id = null;
        int deposit = 0;
        int totalRentFee = 0;
        boolean check = true;
        System.out.println(FuramaController.THUT+"list contract");
        if(contractList.size()>0){
            for(Contract contract :contractList){
                System.out.println(contract);
            }
            do{
                check = true;
                System.out.println("please input Id of contract what you want to edit");
                id = scanner.nextLine();
                for(Contract contract: contractList){
                    if(contract.getContractIdNo().toLowerCase().equals(id.toLowerCase())){
                        check = false;
                        do{
                            try{
                                System.out.println("Please input deposit");
                                deposit = Integer.parseInt(scanner.nextLine());
                            }catch (Exception e){
                                System.out.println("Deposit must be a number and positive");
                                continue;
                            }
                            if(deposit<0){
                                System.out.println("Deposit must be a number and positive");
                                continue;
                            }
                            break;
                        }while(true);

                        do{
                            try{
                                System.out.println("Please input totalRentFee");
                                totalRentFee = Integer.parseInt(scanner.nextLine());
                            }catch (Exception e){
                                System.out.println("total rent fee must be a number and bigger deposit");
                                continue;
                            }
                            if(totalRentFee<deposit){
                                System.out.println("total rent fee must be a number and bigger deposit");
                                continue;
                            }
                            break;
                        }while(true);

                        contract.setDeposit(deposit);
                        contract.setTotalRentFee(totalRentFee);
                    }
                }
                if(check){
                    System.out.println("id dose not match, please input again");
                }

            }while(check);
        }else{
            System.out.println(FuramaController.THUT+"(^_^)_______________________________________________(^_^)");
            System.out.println(FuramaController.THUT+"There is not any contract. please add");
            System.out.println(FuramaController.THUT+"(^_^)_______________________________________________(^_^)");
            System.out.println();
        }


        writeContract();
    }

}
