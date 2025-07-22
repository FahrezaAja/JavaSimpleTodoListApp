public class AplikasiToDoList {


    public static String[] model = new String[10];

    public static java.util.Scanner scanner = new java.util.Scanner(System.in);


    public static void main(String[] args) {
//        testShowToDoList();
//        testAddToDoList();
//        testRemoveToDoList();
//        testInput();
//        testViewShowToDoList();
//        testViewAddToDoList();
//        testViewRemoveToDoList();
        viewShowToDoList();

    }

    /**
     * Menampilkan ToDo List
     */
    public static void showToDoList(){
        System.out.println("To-Do List");
        for (var i = 0; i < model.length; i++){
            var todo = model[i];
            var nomor = i + 1;
            if(todo != null){
                System.out.println(nomor + ". " + todo);
            }
        }

    }

    /**
     * membuat test menampilkan todo list
     */
    public static void testShowToDoList(){
        model[0] = "Belajar Java Dari 0";
        model[9] = "Belajar Jawa";

        showToDoList();
    }

    /**
     * Menambah ke ToDo List
     */
    public static void addToDoList(String todo){
        //mengecek apakah to do list penuh
        //menginisialisasi var awal sebagai true atau penuh
        var isFull = true;
        for (int i = 0; i < model.length; i++) {

            if (model[i] == null){
                isFull = false;
                break;
            }
        }

        //jika penuh
        if (isFull){
            //membuat variabel temporary agar todolist sebelumnya yang telah dimasukkan tidak menghilang ketika
            //panjangnya dibuat baru dan dikali 2
            var temp = model;
            model = new String [model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];

            }
        }


        //menambah todo list
        for (int i = 0; i < model.length; i++) {
            if(model[i] == null){
                model[i] = todo;
                break;
            }

        }

    }

    /**
     * membuat test untuk menambahkan ke todo list
     */
    public static void testAddToDoList(){
        for (int i = 1; i < 25; i++) {
            addToDoList("Contoh ToDoList ke-" + i);
        }

        showToDoList();
    }

    /**
     * Menghapus dari ToDo List
     */
    public static boolean removeToDoList(Integer number){
        if((number - 1) >= model.length){
            return false;
        } else if (model[number - 1] == null) {
            return false;
        } else {
            for (int i = (number - 1); i < model.length; i++) {
                if(i == model.length - 1){
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }

    }
    /**
     * membuat test untuk meghapus todo list
     */

    public static void testRemoveToDoList(){
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");


//        showToDoList();

        //mencoba menghapus nomor yang lebih panjang dari panjang array model
        var result = removeToDoList(40);
        System.out.println(result);

        //mencoba menghapus todolist yang tidak ada isinya
        result = removeToDoList(4);
        System.out.println(result);

        //mencoba menghapus index ke 2
        result = removeToDoList(2);
        System.out.println(result);

        showToDoList();


    }

    /**
     *
     * Menerima inputan dari user
     */
    public static String input(String info){
        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;

    }

    public static void testInput(){
        var name = input("Nama: ");
        System.out.println("Hi " + name);

        var channel = input("Channel: ");
        System.out.println(channel);
    }

    /**
     * Menampilkan view Todo List
     */
    public static void viewShowToDoList(){
        while(true){
            showToDoList();

            System.out.println("Menu");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("x. Keluar");

            var input = input("pilih");
            if (input.equals("1")){ //input.equals jika ingin menggunakan string
                viewAddToDoList();
            } else if (input.equals("2")){
                viewRemoveToDoList();
            } else if (input.equals("x")){
                break;
            } else{
                System.out.println("Pilih tidak ditemukan");
            }
        }

    }

    /**
     * Membuat test untuk view show Todo List
     */
    public static void testViewShowToDoList(){
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");
        addToDoList("Empat");
        addToDoList("Lima");
        viewShowToDoList();
    }

    /**
     * Menampilkan view menambahkan Todo List
     */
    public static void viewAddToDoList(){
        System.out.println("Menambah Todo List");

        var todo = input("Todo (x jika batal)");

        if (todo.equals("x")){
            //batal
        } else {
            addToDoList(todo);
        }

    }

    /**
     * Membuat test untuk view Todo List
     */

    public static void testViewAddToDoList(){
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");

        viewAddToDoList();

        showToDoList();
    }

    /**
     * Menampilkan view menghapus Todo List
     */
    public static void viewRemoveToDoList(){
        System.out.println("Menghapus Todo List");

        var number = input("Nomor yang dihapus (x jika batal)");
        if (number.equals("x")){
            //batal
        } else {
            boolean success = removeToDoList(Integer.valueOf(number));
            if(!success){
                System.out.println("Gagal menghapus : "+ number);
            }
        }

    }

    /**
     * Membuat test view untuk remove Todo List
     */

    public static void testViewRemoveToDoList(){
        addToDoList("Satu");
        addToDoList("Dua");
        addToDoList("Tiga");


        showToDoList();
        viewRemoveToDoList();
        showToDoList();
    }
}
