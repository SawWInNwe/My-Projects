import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class HospitalSystem {
    static class Patient {
        int patientId;
        String name;
        int age;
        String department;

        public Patient(int patientId, String name, int age, String department) {
            this.patientId = patientId;
            this.name = name;
            this.age = age;
            this.department = department;
        }
    }

    List<Patient> patients;

    public HospitalSystem() {
        this.patients = new ArrayList<>();
    }

    public int generatePatientId(String name, int age, String department) {
        String idString = name.substring(0, 3) + age + department.substring(0, 3);
        return idString.hashCode(); // Using hash code as a unique ID
    }

    public void insertPatient() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter patient name:");
        String name = scanner.next();
        System.out.println("Enter patient age:");
        int age = scanner.nextInt();
        System.out.println("Enter patient department:");
        String department = scanner.next();

        int patientId = generatePatientId(name, age, department);
        Patient patient = new Patient(patientId, name, age, department);
        patients.add(patient);
        System.out.println("Patient added successfully! Patient ID: " + patientId);
    }

    public Patient searchPatient(int patientId) {
        for (Patient patient : patients) {
            if (patient.patientId == patientId) {
                return patient;
            }
        }
        return null;
    }

    public boolean deletePatient(int patientId) {
        for (Patient patient : patients) {
            if (patient.patientId == patientId) {
                patients.remove(patient);
                return true;
            }
        }
        return false;
    }

    public void insertionSort() {
        for (int i = 1; i < patients.size(); i++) {
            Patient key = patients.get(i);
            int j = i - 1;
            while (j >= 0 && patients.get(j).patientId > key.patientId) {
                patients.set(j + 1, patients.get(j));
                j = j - 1;
            }
            patients.set(j + 1, key);
        }
    }

    public void mergeSort() {
        mergeSortHelper(0, patients.size() - 1);
    }

    private void mergeSortHelper(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSortHelper(left, mid);
            mergeSortHelper(mid + 1, right);
            merge(left, mid, right);
        }
    }

    private void merge(int left, int mid, int right) {
        List<Patient> temp = new ArrayList<>();
        int i = left, j = mid + 1;
        while (i <= mid && j <= right) {
            if (patients.get(i).patientId <= patients.get(j).patientId) {
                temp.add(patients.get(i++));
            } else {
                temp.add(patients.get(j++));
            }
        }
        while (i <= mid) {
            temp.add(patients.get(i++));
        }
        while (j <= right) {
            temp.add(patients.get(j++));
        }
        for (int k = left; k <= right; k++) {
            patients.set(k, temp.get(k - left));
        }
    }

    // Method for finding shortest paths between hospitals and departments
    // Placeholder implementation
    public List<String> findShortestPaths(String startHospital, String endDepartment) {
        // Placeholder for finding shortest paths
        return new ArrayList<>();
    }

    // Method to handle invalid choices in the main menu
    private void handleInvalidChoice() {
        System.out.println("Invalid choice. Please try again.");
    }

    // Method to display the patient list
    private void displayPatientList(List<Patient> patientList) {
        System.out.println("Patient List:");
        for (Patient patient : patientList) {
            System.out.println("ID: " + patient.patientId + ", Name: " + patient.name + ", Age: " + patient.age + ", Department: " + patient.department);
        }
    }

    // Main method to run the application
    public static void main(String[] args) {
        HospitalSystem hospitalSystem = new HospitalSystem();
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Sort Patients (Insertion Sort)");
            System.out.println("5. Sort Patients (Merge Sort)");
            System.out.println("6. Find Shortest Paths");
            System.out.println("7. Exit");
            System.out.println("Enter your choice:");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    hospitalSystem.insertPatient();
                    break;
                case 2:
                    System.out.println("Enter patient ID to search:");
                    int patientId = scanner.nextInt();
                    Patient foundPatient = hospitalSystem.searchPatient(patientId);
                    if (foundPatient != null) {
                        System.out.println("Patient found:");
                        System.out.println("Name: " + foundPatient.name);
                        System.out.println("Age: " + foundPatient.age);
                        System.out.println("Department: " + foundPatient.department);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;
                case 3:
                    System.out.println("Enter patient ID to delete:");
                    int patientIdToDelete = scanner.nextInt();
                    boolean deleted = hospitalSystem.deletePatient(patientIdToDelete);
                    if (deleted) {
                        System.out.println("Patient deleted successfully.");
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;
                case 4:
                    hospitalSystem.insertionSort();
                    hospitalSystem.displayPatientList(hospitalSystem.patients);
                    break;
                case 5:
                    hospitalSystem.mergeSort();
                    hospitalSystem.displayPatientList(hospitalSystem.patients);
                    break;
                case 6:
                    // Implement finding shortest paths between hospitals and departments
                    System.out.println("Finding shortest paths...");
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    break;
                default:
                    hospitalSystem.handleInvalidChoice();
                    break;
            }

        } while (choice != 7);
    }
}
