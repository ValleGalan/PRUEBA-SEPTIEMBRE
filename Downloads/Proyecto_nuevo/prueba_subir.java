
public static void main(String[] args) {
        // Entrada de datos     
        Scanner scanner = new Scanner(System.in);

        // 1. MÓDULO DE INGRESO Y VALIDACIÓN
        String nombre = leerTexto(scanner);
        int horas = leerEnteroPositivo(scanner);
        double valorHora = leerDoublePositivo(scanner);

        // 2. MÓDULO DE CÁLCULOS
        double salarioBruto = calcularSalarioBruto(horas, valorHora);
        double montoDescuento = calcularDescuento(salarioBruto);
        double salarioNeto = salarioBruto - montoDescuento;

        // 3. MÓDULO DE SALIDA
        mostrarResumen(nombre, salarioBruto, montoDescuento, salarioNeto);

        scanner.close();
    }

    // --- MÉTODOS DE VALIDACIÓN E INGRESO (CONTROL DE ERRORES) ---

    // Valida que la cadena ingresada no esté vacía
    public static String leerTexto(Scanner scanner) {
        String texto = "";
        while (texto.isEmpty()) {
            System.out.print("Ingrese el nombre del empleado: ");
            texto = scanner.nextLine();
            
            if (texto.isEmpty()) {
                System.out.println("Error: El campo no puede estar vacío.");
            }
        }

        return texto;
    }

    // Controla que se ingrese un entero positivo y no texto
    public static int leerEnteroPositivo(Scanner scanner) {
        int numero = -1;
        while (numero < 0) {
            System.out.print("Ingrese las horas trabajadas en la semana: ");
            numero = scanner.nextInt();
            if (numero < 0) {
                    System.out.println("Error: Debe ingresar un valor positivo.");
                }        
        }
        return numero;
    }

    // Controla que se ingrese un decimal positivo y no texto
    public static double leerDoublePositivo(Scanner scanner) {
        double numero = -1;
        while (numero <= 0) {
            System.out.print("Ingrese el valor de la hora trabajada: ");
                numero = scanner.nextDouble();
                if (numero <= 0) {
                    System.out.println("Error: Debe ingresar un valor mayor a cero.");
                }
            
        }
        return numero;
    }

    // --- MÉTODOS DE LÓGICA / CÁLCULOS ---

    public static double calcularSalarioBruto(int horas, double valorHora) {
        if (horas <= 40) {
            return horas * valorHora;
        } else {
            int horasExtras = horas - 40;
            double pagoNormal = 40 * valorHora;
            double pagoExtra = horasExtras * (valorHora * 1.5);
            return pagoNormal + pagoExtra;
        }
    }

    public static double calcularDescuento(double salarioBruto) {
        double porcentaje = 0;
        if (salarioBruto <= 1000000) {
            porcentaje = 0.09;
        } else if (salarioBruto <= 3000000) {
            porcentaje = 0.12;
        } else {
            porcentaje = 0.15;
        }
        return salarioBruto * porcentaje;
    }

    // --- MÓDULO DE SALIDA ---

    public static void mostrarResumen(String nombre, double bruto, double descuento, double neto) {
        System.out.println("\n----------------------------------");
        System.out.println("RESUMEN DE LIQUIDACIÓN");
        System.out.println("----------------------------------");
        System.out.println("Empleado: " + nombre);
        System.out.println("Salario Brut