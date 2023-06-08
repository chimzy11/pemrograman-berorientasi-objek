import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class NilaiAkhir {
    private String mataKuliah;
    private String grade;
    private float nilaiAkhir;

    public NilaiAkhir(String mataKuliah, String grade, float nilaiAkhir) {
        this.mataKuliah = mataKuliah;
        this.grade = grade;
        this.nilaiAkhir = nilaiAkhir;
    }

    public String getMataKuliah() {
        return mataKuliah;
    }

    public String getGrade() {
        return grade;
    }

    public float getNilaiAkhir() {
        return nilaiAkhir;
    }
}

public class No2_InputNilai {
    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<NilaiAkhir> daftarNilai = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        String namaMahasiswa, mataKuliah, nimMahasiswa;
        int jumlahKehadiran, nilaiUAS, nilaiUTS;
        int pilihSemester, pilihMatkul;
        boolean ulang = false;
        System.out.println("\n       PROGRAM REKAPITULASI HASIL STUDI MAHASISWA ");
        System.out.println("               PROGRAM STUDI INFORMATIKA");
        System.out.println("         FAKULTAS TEKNIK UNIVERSITAS MULAWARMAN");
        System.out.println("-------------------------------------------------------------");

        System.out.print("Nama Lengkap Mahasiswa        : ");
        namaMahasiswa = input.readLine();

        System.out.print("NIM Mahasiswa                 : ");
        nimMahasiswa = input.readLine();

        String inputLagi = "";

        do {
            System.out.println("\nSEMESTER");
            System.out.println("-------------------------------------------------------------");
            System.out.println("[1] Semester 1");
            System.out.println("[2] Semester 2");
            System.out.println("[3] Semester 3");
            System.out.println("[4] Semester 4");
            System.out.println("[5] Semester 5");
            System.out.println("[6] Semester 6");
            System.out.print("\nPilih Semester : ");
            pilihSemester = Integer.parseInt(input.readLine());
                
            switch(pilihSemester){
                case 1 :
                    do {
                        do{
                            System.out.println("\nSEMESTER 1");
                            System.out.println("-------------------------------------------------------------");
                            System.out.println("[1] Algoritma dan Pemrograman Dasar");
                            System.out.println("[2] Ilmu Sosial dan Budaya");
                            System.out.println("[3] Pengantar Teknologi Informasi");
                            System.out.println("[4] Pendidikan Agama");
                            System.out.println("[5] Pendidikan Pancasila");
                            System.out.println("[6] Bahasa Inggris 1");
                            System.out.println("[7] Kalkulus");
                            System.out.println("[8] Logika Informatika");
                            System.out.println("[9] Fisika Dasar");
                            System.out.print("\nPilih Mata Kuliah : ");
                            pilihMatkul = Integer.parseInt(input.readLine());
                        } while (pilihMatkul > 9 || pilihMatkul < 1);

                        switch (pilihMatkul) {
                            case 1:
                                mataKuliah = "Algoritma dan Pemrograman Dasar";
                                break;
                            case 2:
                                mataKuliah = "Ilmu Sosial dan Budaya";
                                break;
                            case 3:
                                mataKuliah = "Pengantar Teknologi Informasi";
                                break;
                            case 4:
                                mataKuliah = "Pendidikan Agama";
                                break;
                            case 5:
                                mataKuliah = "Pendidikan Pancasila";
                                break;
                            case 6:
                                mataKuliah = "Bahasa Inggris 1";
                                break;
                            case 7:
                                mataKuliah = "Kalkulus";
                                break;
                            case 8:
                                mataKuliah = "Logika Informatika";
                                break;
                            case 9:
                                mataKuliah = "Fisika Dasar";
                                break;
                            default:
                                mataKuliah = "Mata Kuliah Tidak Valid";
                                break;
                        }
                        
                        System.out.println("\nInput Nilai " + mataKuliah);
                        System.out.println("-------------------------------------------------------------");
                        nilaiUAS = getValidatedInput("Nilai Ujian Akhir Semester     : ");
                        nilaiUTS = getValidatedInput("Nilai Ujian Tengah Semester    : ");

                        do {
                            jumlahKehadiran = getValidatedInput("Jumlah Kehadiran (8 Pertemuan) : ");
                            if (jumlahKehadiran > 8 || jumlahKehadiran < 0) {
                                System.out.println("\nMaksimal 8 pertemuan dan minimal 0 kehadiran!");
                            }
                        } while (jumlahKehadiran > 8 || jumlahKehadiran < 0);
                        
                        int nilaiKehadiran = calculateNilaiKehadiran(jumlahKehadiran);
                        float nilaiAkhir = calculateNilaiAkhir(nilaiKehadiran, nilaiUTS, nilaiUAS);
                        String grade = calculateGrade(nilaiAkhir);
            
                        NilaiAkhir nilai = new NilaiAkhir(mataKuliah, grade, nilaiAkhir);
                        daftarNilai.add(nilai);
                        System.out.print("\nInput Nilai Mata Kuliah lagi(y/n)? ");
                        inputLagi = input.readLine();
                    } while (inputLagi.equalsIgnoreCase("y"));
            
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("\nNama Lengkap       : " + namaMahasiswa);
                    System.out.println("NIM                : " + nimMahasiswa);
                    System.out.println("Program Studi      : Informatika");
                    System.out.println("Semester           : 1");
                    System.out.println("+-----------------------------------------------------------+");
                    System.out.println("|                   HASIL STUDI SEMESTER 1                  |");
                    System.out.println("+-----------------------------------------------------------+");
                    System.out.println("|             Mata Kuliah             | Nilai Akhir | Grade |");
                    System.out.println("+-------------------------------------+-------------+-------+");
                    for (NilaiAkhir nilai : daftarNilai) {
                        System.out.println(String.format("| %-35s |    %-5s    |   %s   |",
                        nilai.getMataKuliah(), nilai.getNilaiAkhir(), nilai.getGrade()));
                    }
                    System.out.println("+-----------------------------------------------------------+");
                    break;
                case 2:
                    do {
                        do{
                            System.out.println("\nSEMESTER 2");
                            System.out.println("-------------------------------------------------------------");
                            System.out.println("[1] Pendidikan Bahasa Indonesia");
                            System.out.println("[2] Pendidikan Kewarganegaraan");
                            System.out.println("[3] Sistem Digital");
                            System.out.println("[4] Metode Numerik");
                            System.out.println("[5] Matematika Diskrit");
                            System.out.println("[6] Algoritma dan Pemrograman Lanjut");
                            System.out.println("[7] Jaringan Komputer");
                            System.out.println("[8] Sistem Operasi");
                            System.out.print("\nPilih Mata Kuliah: ");
                            pilihMatkul = Integer.parseInt(input.readLine());
                        } while (pilihMatkul > 8 || pilihMatkul < 1);

                        switch (pilihMatkul) {
                            case 1:
                                mataKuliah = "Pendidikan Bahasa Indonesia";
                                break;
                            case 2:
                                mataKuliah = "Pendidikan Kewarganegaraan";
                                break;
                            case 3:
                                mataKuliah = "Sistem Digital";
                                break;
                            case 4:
                                mataKuliah = "Metode Numerik";
                                break;
                            case 5:
                                mataKuliah = "Matematika Diskrit";
                                break;
                            case 6:
                                mataKuliah = "Algoritma dan Pemrograman Lanjut";
                                break;
                            case 7:
                                mataKuliah = "Jaringan Komputer";
                                break;
                            case 8:
                                mataKuliah = "Sistem Operasi";
                                break;
                            default:
                                mataKuliah = "Mata Kuliah Tidak Valid";
                                break;
                            }
                            System.out.println("\nInput Nilai " + mataKuliah);
                            System.out.println("-------------------------------------------------------------");
                            nilaiUAS = getValidatedInput("Nilai Ujian Akhir Semester     : ");
                            nilaiUTS = getValidatedInput("Nilai Ujian Tengah Semester    : ");
        
                        do {
                            jumlahKehadiran = getValidatedInput("Jumlah Kehadiran (8 Pertemuan) : ");
                            if (jumlahKehadiran > 8 || jumlahKehadiran < 0) {
                                System.out.println("\nMaksimal 8 pertemuan dan minimal 0 kehadiran!");
                            }
                        } while (jumlahKehadiran > 8 || jumlahKehadiran < 0);
                            
                        int nilaiKehadiran = calculateNilaiKehadiran(jumlahKehadiran);
                        float nilaiAkhir = calculateNilaiAkhir(nilaiKehadiran, nilaiUTS, nilaiUAS);
                        String grade = calculateGrade(nilaiAkhir);
                
                        NilaiAkhir nilai = new NilaiAkhir(mataKuliah, grade, nilaiAkhir);
                        daftarNilai.add(nilai);
                        System.out.print("\nInput Nilai Mata Kuliah lagi(y/n)? ");
                        inputLagi = input.readLine();
                    } while (inputLagi.equalsIgnoreCase("y"));
                
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("\nNama Lengkap       : " + namaMahasiswa);
                    System.out.println("NIM                : " + nimMahasiswa);
                    System.out.println("Program Studi      : Informatika");
                    System.out.println("Semester           : 2");
                    System.out.println("+-----------------------------------------------------------+");
                    System.out.println("|                   HASIL STUDI SEMESTER 2                  |");
                    System.out.println("+-----------------------------------------------------------+");
                    System.out.println("|             Mata Kuliah             | Nilai Akhir | Grade |");
                    System.out.println("+-------------------------------------+-------------+-------+");
                    for (NilaiAkhir nilai : daftarNilai) {
                        System.out.println(String.format("| %-35s |    %-5s    |   %s   |",
                        nilai.getMataKuliah(), nilai.getNilaiAkhir(), nilai.getGrade()));
                        System.out.println("+-----------------------------------------------------------+");
                    }
                    break;
                case 3:
                    do {
                        do{
                            System.out.println("\nSEMESTER 3");
                            System.out.println("-------------------------------------------------------------");
                            System.out.println("[1] Struktur Data");
                            System.out.println("[2] Organisasi dan Arsitektur Komputer");
                            System.out.println("[3] Aljabar Linear");
                            System.out.println("[4] Probabilitas dan Statistika");
                            System.out.println("[5] Keamanan Komputer");
                            System.out.println("[6] Basis Data");
                            System.out.println("[7] Pemrograman Web");
                            System.out.println("[8] Kecerdasan Buatan");
                            System.out.print("\nPilih Mata Kuliah: ");
                            pilihMatkul = Integer.parseInt(input.readLine());
                        } while (pilihMatkul > 8 || pilihMatkul < 1);

                        switch (pilihMatkul) {
                            case 1:
                                mataKuliah = "Struktur Data";
                                break;
                            case 2:
                                mataKuliah = "Organisasi dan Arsitektur Komputer";
                                break;
                            case 3:
                                mataKuliah = "Aljabar Linear";
                                break;
                            case 4:
                                mataKuliah = "Probabilitas dan Statistika*";
                                break;
                            case 5:
                                mataKuliah = "Keamanan Komputer";
                                break;
                            case 6:
                                mataKuliah = "Basis Data*";
                                break;
                            case 7:
                                mataKuliah = "Pemrograman Web*";
                                break;
                            case 8:
                                mataKuliah = "Kecerdasan Buatan*";
                                break;
                            default:
                                mataKuliah = "Mata Kuliah Tidak Valid";
                                break;
                        }
                        System.out.println("\nInput Nilai " + mataKuliah);
                        System.out.println("-------------------------------------------------------------");
                        nilaiUAS = getValidatedInput("Nilai Ujian Akhir Semester     : ");
                        nilaiUTS = getValidatedInput("Nilai Ujian Tengah Semester    : ");
        
                        do {
                            jumlahKehadiran = getValidatedInput("Jumlah Kehadiran (8 Pertemuan) : ");
                            if (jumlahKehadiran > 8 || jumlahKehadiran < 0) {
                                System.out.println("\nMaksimal 8 pertemuan dan minimal 0 kehadiran!");
                            }
                        } while (jumlahKehadiran > 8 || jumlahKehadiran < 0);
                            
                        int nilaiKehadiran = calculateNilaiKehadiran(jumlahKehadiran);
                        float nilaiAkhir = calculateNilaiAkhir(nilaiKehadiran, nilaiUTS, nilaiUAS);
                        String grade = calculateGrade(nilaiAkhir);
                
                        NilaiAkhir nilai = new NilaiAkhir(mataKuliah, grade, nilaiAkhir);
                        daftarNilai.add(nilai);
                        System.out.print("\nInput Nilai Mata Kuliah lagi(y/n)? ");
                        inputLagi = input.readLine();
                    } while (inputLagi.equalsIgnoreCase("y"));

                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("\nNama Lengkap       : " + namaMahasiswa);
                    System.out.println("NIM                : " + nimMahasiswa);
                    System.out.println("Program Studi      : Informatika");
                    System.out.println("Semester           : 3");
                    System.out.println("+-----------------------------------------------------------+");
                    System.out.println("|                   HASIL STUDI SEMESTER 3                  |");
                    System.out.println("+-----------------------------------------------------------+");
                    System.out.println("|             Mata Kuliah             | Nilai Akhir | Grade |");
                    System.out.println("+-------------------------------------+-------------+-------+");
                    for (NilaiAkhir nilai : daftarNilai) {
                        System.out.println(String.format("| %-35s |    %-5s    |   %s   |",
                        nilai.getMataKuliah(), nilai.getNilaiAkhir(), nilai.getGrade()));
                    }
                    System.out.println("+-----------------------------------------------------------+");
                    break;
                case 4:
                    do{
                        do{
                            System.out.println("\nSEMESTER 4");
                            System.out.println("-------------------------------------------------------------");
                            System.out.println("[1] Pemrograman Visual");
                            System.out.println("[2] Sistem Terdistribusi");
                            System.out.println("[3] Komputer dan Masyarakat");
                            System.out.println("[4] Pemrograman Berorientasi Objek");
                            System.out.println("[5] Rekayasa Perangkat Lunak");
                            System.out.println("[6] Wirausaha Teknologi");
                            System.out.println("[7] Interaksi Manusia dan Komputer");
                            System.out.println("[8] Bahasa Inggris 2");
                            System.out.print("\nPilih Mata Kuliah: ");
                            pilihMatkul = Integer.parseInt(input.readLine());
                        } while (pilihMatkul > 8 || pilihMatkul < 1);
                        switch (pilihMatkul) {
                            case 1:
                                mataKuliah = "Pemrograman Visual";
                                break;
                            case 2:
                                mataKuliah = "Sistem Terdistribusi";
                                break;
                            case 3:
                                mataKuliah = "Komputer dan Masyarakat";
                                break;
                            case 4:
                                mataKuliah = "Pemrograman Berorientasi Objek";
                                break;
                            case 5:
                                mataKuliah = "Rekayasa Perangkat Lunak";
                                break;
                            case 6:
                                mataKuliah = "Wirausaha Teknologi";
                                break;
                            case 7:
                                mataKuliah = "Interaksi Manusia dan Komputer";
                                break;
                            case 8:
                                mataKuliah = "Bahasa Inggris 2";
                                break;
                            default:
                                mataKuliah = "Mata Kuliah Tidak Valid";
                                break;
                        }
                        System.out.println("\nInput Nilai " + mataKuliah);
                        System.out.println("-----------------------------------------------");
                        nilaiUAS = getValidatedInput("Nilai Ujian Akhir Semester     : ");
                        nilaiUTS = getValidatedInput("Nilai Ujian Tengah Semester    : ");
        
                        do {
                            jumlahKehadiran = getValidatedInput("Jumlah Kehadiran (8 Pertemuan) : ");
                            if (jumlahKehadiran > 8 || jumlahKehadiran < 0) {
                                System.out.println("\nMaksimal 8 pertemuan dan minimal 0 kehadiran!");
                            }
                        } while (jumlahKehadiran > 8 || jumlahKehadiran < 0);
                            
                        int nilaiKehadiran = calculateNilaiKehadiran(jumlahKehadiran);
                        float nilaiAkhir = calculateNilaiAkhir(nilaiKehadiran, nilaiUTS, nilaiUAS);
                        String grade = calculateGrade(nilaiAkhir);
                
                        NilaiAkhir nilai = new NilaiAkhir(mataKuliah, grade, nilaiAkhir);
                        daftarNilai.add(nilai);
                        System.out.print("\nInput Nilai Mata Kuliah lagi(y/n)? ");
                        inputLagi = input.readLine();
                    } while (inputLagi.equalsIgnoreCase("y"));
                
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("\nNama Lengkap       : " + namaMahasiswa);
                    System.out.println("NIM                : " + nimMahasiswa);
                    System.out.println("Program Studi      : Informatika");
                    System.out.println("Semester           : 4");
                    System.out.println("+-----------------------------------------------------------+");
                    System.out.println("|                   HASIL STUDI SEMESTER 4                  |");
                    System.out.println("+-----------------------------------------------------------+");
                    System.out.println("|             Mata Kuliah             | Nilai Akhir | Grade |");
                    System.out.println("+-------------------------------------+-------------+-------+");
                    for (NilaiAkhir nilai : daftarNilai) {
                        System.out.println(String.format("| %-35s |    %-5s    |   %s   |",
                        nilai.getMataKuliah(), nilai.getNilaiAkhir(), nilai.getGrade()));
                    }
                    System.out.println("+-----------------------------------------------------------+");
                    break;
                case 5:
                    do{
                        do{
                            System.out.println("\nSEMESTER 5");
                            System.out.println("-------------------------------------------------------------");
                            System.out.println("[1] Jaringan Komputer Lanjut");
                            System.out.println("[2] Teori Bahasa dan Otomata");
                            System.out.println("[3] Grafika Komputer");
                            System.out.println("[4] Pemrograman Piranti Bergerak");
                            System.out.println("[5] Etika Profesi IT");
                            System.out.println("[6] Manajemen Proyek TI");
                            System.out.print("\nPilih Mata Kuliah: ");
                            pilihMatkul = Integer.parseInt(input.readLine());
                        } while (pilihMatkul > 6 || pilihMatkul < 1);
                        switch (pilihMatkul) {
                            case 1:
                                mataKuliah = "Jaringan Komputer Lanjut";
                                break;
                            case 2:
                                mataKuliah = "Teori Bahasa dan Otomata";
                                break;
                            case 3:
                                mataKuliah = "Grafika Komputer";
                                break;
                            case 4:
                                mataKuliah = "Pemrograman Piranti Bergerak";
                                break;
                            case 5:
                                mataKuliah = "Etika Profesi IT";
                                break;
                            case 6:
                                mataKuliah = "Manajemen Proyek TI";
                                break;
                            default:
                                mataKuliah = "Pilihan mata kuliah tidak valid";
                                break;
                        }

                        System.out.println("\nInput Nilai " + mataKuliah);
                        System.out.println("-----------------------------------------------");
                        nilaiUAS = getValidatedInput("Nilai Ujian Akhir Semester     : ");
                        nilaiUTS = getValidatedInput("Nilai Ujian Tengah Semester    : ");
        
                        do {
                            jumlahKehadiran = getValidatedInput("Jumlah Kehadiran (8 Pertemuan) : ");
                            if (jumlahKehadiran > 8 || jumlahKehadiran < 0) {
                                System.out.println("\nMaksimal 8 pertemuan dan minimal 0 kehadiran!");
                            }
                        } while (jumlahKehadiran > 8 || jumlahKehadiran < 0);
                            
                        int nilaiKehadiran = calculateNilaiKehadiran(jumlahKehadiran);
                        float nilaiAkhir = calculateNilaiAkhir(nilaiKehadiran, nilaiUTS, nilaiUAS);
                        String grade = calculateGrade(nilaiAkhir);
                
                        NilaiAkhir nilai = new NilaiAkhir(mataKuliah, grade, nilaiAkhir);
                        daftarNilai.add(nilai);
                        System.out.print("\nInput Nilai Mata Kuliah lagi(y/n)? ");
                        inputLagi = input.readLine();
                    } while (inputLagi.equalsIgnoreCase("y"));
                
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("\nNama Lengkap       : " + namaMahasiswa);
                    System.out.println("NIM                : " + nimMahasiswa);
                    System.out.println("Program Studi      : Informatika");
                    System.out.println("Semester           : 5");
                    System.out.println("+-----------------------------------------------------------+");
                    System.out.println("|                   HASIL STUDI SEMESTER 5                  |");
                    System.out.println("+-----------------------------------------------------------+");
                    System.out.println("|             Mata Kuliah             | Nilai Akhir | Grade |");
                    System.out.println("+-------------------------------------+-------------+-------+");
                    for (NilaiAkhir nilai : daftarNilai) {
                        System.out.println(String.format("| %-35s |    %-5s    |   %s   |",
                        nilai.getMataKuliah(), nilai.getNilaiAkhir(), nilai.getGrade()));
                    }
                    System.out.println("+-----------------------------------------------------------+");
                    break;
                case 6:
                    do{
                        System.out.println("\nSEMESTER 6");
                        System.out.println("-------------------------------------------------------------");
                        System.out.println("[1] Metode Penelitian Riset TI");
                        System.out.print("\nPilih Mata Kuliah: ");
                        pilihMatkul = Integer.parseInt(input.readLine());

                        switch (pilihMatkul) {
                            case 1:
                                mataKuliah = "Metode Penelitian Riset TI";
                                break;
                            default:
                                mataKuliah = "Pilihan mata kuliah tidak valid";
                                break;
                        }
                    } while (pilihMatkul > 8 || pilihMatkul < 1);
                    System.out.println("\nInput Nilai " + mataKuliah);
                    System.out.println("-----------------------------------------------");
                    nilaiUAS = getValidatedInput("Nilai Ujian Akhir Semester     : ");
                    nilaiUTS = getValidatedInput("Nilai Ujian Tengah Semester    : ");
    
                    do {
                        jumlahKehadiran = getValidatedInput("Jumlah Kehadiran (8 Pertemuan) : ");
                        if (jumlahKehadiran > 8 || jumlahKehadiran < 0) {
                            System.out.println("\nMaksimal 8 pertemuan dan minimal 0 kehadiran!");
                        }
                    } while (jumlahKehadiran > 8 || jumlahKehadiran < 0);
                        
                    int nilaiKehadiran = calculateNilaiKehadiran(jumlahKehadiran);
                    float nilaiAkhir = calculateNilaiAkhir(nilaiKehadiran, nilaiUTS, nilaiUAS);
                    String grade = calculateGrade(nilaiAkhir);
                
                    NilaiAkhir nilai = new NilaiAkhir(mataKuliah, grade, nilaiAkhir);
                    daftarNilai.add(nilai);
                
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("\nNama Lengkap       : " + namaMahasiswa);
                    System.out.println("NIM                : " + nimMahasiswa);
                    System.out.println("Program Studi      : Informatika");
                    System.out.println("Semester           : 6");
                    System.out.println("+-----------------------------------------------------------+");
                    System.out.println("|                   HASIL STUDI SEMESTER 6                  |");
                    System.out.println("+-----------------------------------------------------------+");
                    System.out.println("|             Mata Kuliah             | Nilai Akhir | Grade |");
                    System.out.println("+-------------------------------------+-------------+-------+");
                    
                    System.out.println(String.format("| %-35s |    %-5s    |   %s   |",
                    nilai.getMataKuliah(), nilai.getNilaiAkhir(), nilai.getGrade()));
                    System.out.println("+-----------------------------------------------------------+");
                    break;
                default:
                    System.out.println("\nPilihan semester tidak valid");
                    
                    break;
                }   
        } while (pilihSemester > 8);
        
    }

    private static int getValidatedInput(String message) throws IOException {
        int inputNilai;
        while (true) {
            System.out.print(message);
            try {
                inputNilai = Integer.parseInt(input.readLine());
                if (inputNilai < 0 || inputNilai > 100) {
                    System.out.println("Nilai maksimal 100 dan minimal 0");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInput harus berupa angka\n");
            }
        }
        return inputNilai;
    }

    private static int calculateNilaiKehadiran(int jumlahKehadiran) {
        if (jumlahKehadiran < 3) {
            return 0;
        } else if (jumlahKehadiran <= 4) {
            return 60;
        } else if (jumlahKehadiran <= 6) {
            return 80;
        } else {
            return 100;
        }
    }
    
    private static float calculateNilaiAkhir(int nilaiKehadiran, int nilaiUTS, int nilaiUAS) {
        return (float) ((0.2 * nilaiKehadiran) + (0.3 * nilaiUTS) + (0.5 * nilaiUAS));
    }
    
    private static String calculateGrade(float nilaiAkhir) {
        if (nilaiAkhir >= 85) {
            return "A";
        } else if (nilaiAkhir >= 70) {
            return "B";
        } else if (nilaiAkhir >= 60) {
            return "C";
        } else if (nilaiAkhir >= 50) {
            return "D";
        } else {
            return "E";
        }
    
    }    
}