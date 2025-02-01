package HospitalManage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
	
public class Methods{
	public static class patients {
	    private int id;
	    private String name;
	    private int age;
	    private String gender;
	    private String contact;
	    private String address;
	   

	    public patients(String name, int age, String gender, String contact, String address) {
	        this.name = name;
	        this.age = age;
	        this.gender = gender;
	        this.contact = contact;
	        this.address = address;
	    }

	    public patients() {
			super();
		}

		public void registerPatient() {
	        String sql = "INSERT INTO Patients (name, age, gender, contact, address) VALUES (?, ?, ?, ?, ?)";
	        try (Connection conn = JDBC.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, name);
	            pstmt.setInt(2, age);
	            pstmt.setString(3, gender);
	            pstmt.setString(4, contact);
	            pstmt.setString(5, address);
	            pstmt.executeUpdate();
	            System.out.println("Patient registered successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void getAllPatients() {
	        String sql = "SELECT * FROM Patients";
	        try (Connection conn = JDBC.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql);
	             ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                System.out.println("ID: " + rs.getInt("patient_id") +
	                        ", Name: " + rs.getString("name") +
	                        ", Age: " + rs.getInt("age") +
	                        ", Gender: " + rs.getString("gender") +
	                        ", Contact: " + rs.getString("contact"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	public class Appointment {
	    public static void scheduleAppointment(int patientId, String doctorName, String date) {
	        String sql = "INSERT INTO Appointments (patient_id, doctor_name, appointment_date, status) VALUES (?, ?, ?, 'Scheduled')";
	        try (Connection conn = JDBC.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, patientId);
	            pstmt.setString(2, doctorName);
	            pstmt.setString(3, date);
	            pstmt.executeUpdate();
	            System.out.println("Appointment scheduled.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	public class Billing {
	    public static void generateInvoice(int i, double amount) {
	        String sql = "INSERT INTO Bills (patient_name, amount, payment_status) VALUES (?, ?, 'Pending')";
	        try (Connection conn = JDBC.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setInt(1, i);
	            pstmt.setDouble(2, amount);
	            pstmt.executeUpdate();
	            System.out.println("Invoice generated successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void getAllBills() {
	        String sql = "SELECT * FROM Bills";
	        try (Connection conn = JDBC.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql);
	             ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                System.out.println("ID: " + rs.getInt("id") +
	                        ", Patient: " + rs.getString("patient_name") +
	                        ", Amount: $" + rs.getDouble("amount") +
	                        ", Status: " + rs.getString("payment_status"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	public class Inventory {
	    public static void addItem(String itemName, int quantity, String supplier) {
	        String sql = "INSERT INTO Inventory (item_name, quantity, supplier) VALUES (?, ?, ?)";
	        try (Connection conn = JDBC.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, itemName);
	            pstmt.setInt(2, quantity);
	            pstmt.setString(3, supplier);
	            pstmt.executeUpdate();
	            System.out.println("Item added to inventory.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	public class MedicalRecords {
	    public static void addRecord(String name, int age, String gender, String diagnosis, String treatment) {
	        String sql = "INSERT INTO MedicalRecords (patient_name, age, gender, diagnosis, treatment) VALUES (?, ?, ?, ?, ?)";
	        try (Connection conn = JDBC.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, name);
	            pstmt.setInt(2, age);
	            pstmt.setString(3, gender);
	            pstmt.setString(4, diagnosis);
	            pstmt.setString(5, treatment);
	            pstmt.executeUpdate();
	            System.out.println("Medical record added successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void getAllRecords() {
	        String sql = "SELECT * FROM MedicalRecords";
	        try (Connection conn = JDBC.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql);
	             ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                System.out.println("ID: " + rs.getInt("id") +
	                        ", Name: " + rs.getString("patient_name") +
	                        ", Age: " + rs.getInt("age") +
	                        ", Diagnosis: " + rs.getString("diagnosis") +
	                        ", Treatment: " + rs.getString("treatment"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	public class Staff {
	    public static void addStaff(String name, String role, String department, String phone, double salary) {
	        String sql = "INSERT INTO Staff (name, role, department, phone, salary) VALUES (?, ?, ?, ?, ?)";
	        try (Connection conn = JDBC.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {
	            pstmt.setString(1, name);
	            pstmt.setString(2, role);
	            pstmt.setString(3, department);
	            pstmt.setString(4, phone);
	            pstmt.setDouble(5, salary);
	            pstmt.executeUpdate();
	            System.out.println("Staff member added successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    public static void getAllStaff() {
	        String sql = "SELECT * FROM Staff";
	        try (Connection conn = JDBC.getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql);
	             ResultSet rs = pstmt.executeQuery()) {
	            while (rs.next()) {
	                System.out.println("ID: " + rs.getInt("id") +
	                        ", Name: " + rs.getString("name") +
	                        ", Role: " + rs.getString("role") +
	                        ", Department: " + rs.getString("department") +
	                        ", Salary: $" + rs.getDouble("salary"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
	public class Main {
	    public static void main(String[] args) {
	       
	        patients p1 = new patients("Horn", 34, "Male", "8976453455", "chennai");
	    	
	        p1.registerPatient();
	        patients p2 = new patients("Jack", 56, "Male", "9870345768", "London");
	        p2.registerPatient();

	        // Schedule an appointment
	        Appointment.scheduleAppointment(1, "Dr. Smith", "2025-02-10");
	        Appointment.scheduleAppointment(2, "Dr. Smackling", "2024-04-12");

	        // Generate a bill
	        Billing.generateInvoice(1, 500.0);
	        Billing.generateInvoice(2, 700.0);

	        // Add an inventory item
	        Inventory.addItem("Paracetamol", 200, "ABC Pharma");
	        Inventory.addItem("Acetomine",100 ,"Apollo Pharma");
	        
	        // MedicalRecords
	        MedicalRecords.addRecord("Horn", 34, "Male", "Fever", "Trips");
	        MedicalRecords.addRecord("Jack", 56, "Male", "stomach Pain", "X-ray");
	        
	        // Staff Records
	        Staff.addStaff("Smrithi", "Nurse", "OP", "8967454231", 2000.0);
	        Staff.addStaff("Borls", "Receptionist", "Registering", "9834562788", 3000.0);

	        // Retrieve all patients
	        patients.getAllPatients();
	        MedicalRecords.getAllRecords();
	        Staff.getAllStaff();
	        Billing.getAllBills();
	    }
	}
	}

