
interface UsbPort {
    void connectWithUsbC();
}

class OldPrinter {
    public void connectWithUsbA() {
        System.out.println("Connected using USB-A port.");
    }
}

class PrinterAdapter implements UsbPort {
    private OldPrinter oldPrinter;
    public PrinterAdapter(OldPrinter printer) {
        this.oldPrinter = printer;
    }
    public void connectWithUsbC() {
        oldPrinter.connectWithUsbA();
        System.out.println("Adapter converted USB-C to USB-A.");
    }
}

public class AdapterDemo {
    public static void main(String[] args) {
        OldPrinter printer = new OldPrinter();
        UsbPort adapter = new PrinterAdapter(printer);
        adapter.connectWithUsbC();
    }
}
