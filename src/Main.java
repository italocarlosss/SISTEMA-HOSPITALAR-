import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

import Consultas.Confirmaçao;
import Consultas.Consultas;
import Consultas.Medicamentos;
import Entidades.pacientes.Historico;
import Entidades.pacientes.Medicos;
import Entidades.pacientes.Paciente;
import Entidades.pacientes.PacienteEspecial;
import Entidades.pacientes.PlanoS;
import pacients.InternaçaoMotivos;
import pacients.Internaçoes;
import Consultas.Salas;
import pacients.Situaçao;


public class Main 
{
    static ArrayList<Paciente> listapacientes = new ArrayList<>();
    static ArrayList<Medicos> medcos = new ArrayList<>();
    static ArrayList<Consultas> listaConsultas = new ArrayList<>();
    static ArrayList<Internaçoes> listainternados = new ArrayList<>();
    static ArrayList<InternaçaoMotivos> diagnostico = new ArrayList<>();
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) 
    {
       
        //persistencia
         carregarPacientes();
    

        //PACIENTES
        ArrayList<InternaçaoMotivos> LucInterna = new ArrayList<>();
            LucInterna.add(InternaçaoMotivos.ANEMIA);

        ArrayList<Historico> LucasHist = new ArrayList<>();
            LucasHist.add(Historico.EXAMES);
            LucasHist.add(Historico.PSIQUIATRA);
        
            ArrayList<InternaçaoMotivos> NiloInterna = new ArrayList<>();
            NiloInterna.add(InternaçaoMotivos.SEM_INTERNAÇÕES_REGISTRADAS);

        ArrayList<Historico> NiloHist = new ArrayList<>();
            NiloHist.add(Historico.CLINICO_GERAL);

            ArrayList<InternaçaoMotivos> MariaInterna = new ArrayList<>();
            MariaInterna.add(InternaçaoMotivos.SEM_INTERNAÇÕES_REGISTRADAS);

        ArrayList<Historico> MariaHist = new ArrayList<>();
            MariaHist.add(Historico.CLINICO_GERAL);

        ArrayList<InternaçaoMotivos> JoseInterna = new ArrayList<>();
            JoseInterna.add(InternaçaoMotivos.SEM_INTERNAÇÕES_REGISTRADAS);

        ArrayList<Historico> JoseHist = new ArrayList<>();
            JoseHist.add(Historico.CARDIOLOGISTA);

        ArrayList<InternaçaoMotivos> EvelynInterna = new ArrayList<>();
            EvelynInterna.add(InternaçaoMotivos.TRABALHO_DE_PARTO);

        ArrayList<Historico> EvelynHist = new ArrayList<>();
            EvelynHist.add(Historico.EXAMES);
        
     //pacientes   
    Paciente p1 = new Paciente("Lucas Boaventura ", 25 , "111-111-111-11 ", LucInterna, LucasHist, 500.0);
    Paciente p2 = new Paciente("Nilo Santana ", 11 , "222-222-222-22 ", NiloInterna, NiloHist, 300.0);
    Paciente p3 = new Paciente("Evelyn Lucy", 37 , "333-333-333-33 ", EvelynInterna, EvelynHist, 400.0);
 
    listapacientes.add(p1);
    listapacientes.add(p2);
    listapacientes.add(p3);
    
    //pacientes especiais 

    PacienteEspecial pe1 = new PacienteEspecial("Maria José", 67, "333-333-333-33", 1700.0, MariaInterna, MariaHist, PlanoS.AMIL);
        
    PacienteEspecial pe2 = new PacienteEspecial("José Bezerra", 45, "444-444-444-44", 2000.0, JoseInterna, JoseHist, PlanoS.BRADESCO);
    JoseInterna.add(InternaçaoMotivos.SEM_INTERNAÇÕES_REGISTRADAS);
    JoseHist.add(Historico.CARDIOLOGISTA); 
    listapacientes.add(pe1);
    listapacientes.add(pe2); 

    
    //medicos
    Medicos m1 = new Medicos("Ítalo Carlos ", "989 ", "CLINICO GERAL" , 130.0);
    Medicos m2 = new Medicos("Gustavo Antonio ", "818 ","PSIQUIATRA", 150.0);
    Medicos m3 = new Medicos("JOAO", "718 ", "CIRURGIAO", 500.0);
    Medicos m4 = new Medicos("Naruto Silva ", "666 ", "PEDIATRA", 250.0);
    Medicos m5 = new Medicos("Lola Maria ", "048 ", "CARDIOLOGISTA", 300.0);
    
    medcos.add(m1);
    medcos.add(m2);
    medcos.add(m3);
    medcos.add(m4);
    medcos.add(m5);

    //dados iniciais       }

     //consultas    
    Consultas c1 = new Consultas(p1, m1, LocalDateTime.of(2024, 01, 30, 13, 00), Salas.Sala_3, null, Confirmaçao.CONSULTA_CONCLUIDA, 130.0);
    LocalDateTime c1DateTime = LocalDateTime.of(2024,01, 30, 13, 00);

    Consultas c2 = new Consultas(pe1, m3, LocalDateTime.of(2023, 9, 16, 07, 30), null, null, Confirmaçao.CONSULTA_CANCELADA, 150.0);
    LocalDateTime c2DateTime = LocalDateTime.of(2023, 9, 16, 07, 30);
    
    listaConsultas.add(c1);
    listaConsultas.add(c2);

    //internaçoes
    Internaçoes in1 = new Internaçoes(p1, m3, Situaçao.ESTAVEL, LocalDateTime.of(2025, 10, 10, 10, 30) , null, new ArrayList<>(), Salas.Sala_6, 700.0);
    LocalDateTime in1DateTime = LocalDateTime.of(2025, 10, 10, 10, 30);
    Internaçoes in2 = new Internaçoes(pe1, m3, Situaçao.INSTAVEL, LocalDateTime.of (2025,10,10,23,54), null, new ArrayList<>() , Salas.Sala_7, 500.0);
    LocalDateTime in2DateTime = LocalDateTime.of(2025,10,10,23,54);
    listainternados.add(in1);
    listainternados.add(in2);   
    Main menu = new Main();
    menu.Menu();

        }
    
    //manu interatvo do terminal
    public void Menu()
    {
    
        Scanner scan = new Scanner (System.in);
        boolean u = true;
        while (true) 
        {
            System.out.println("\n----------BEM VINDOS AO HOSPITAL FCTE----------");
            System.out.println("Digite 1: Cadastrar Paciente");
            System.out.println("Digite 2: Cadastrar Paciente Especial");
            System.out.println("Digite 3: Cadastrar ou listar Médicos");
            System.out.println("Digite 4: Internações");
            System.out.println("Digite 5: Consultar");
            System.out.println("Digite 6: Relatórios");
            System.out.println("Digite 0: Sair");
            System.out.println("Escolha uma das opções:");

            int a = scan.nextInt();

            switch (a) 
            {
                case 1:
                    MenuPaciente();
                    break;
                case 2:
                    MenuPacienteEspecial();
                    break;
                case 3:
                    MenuMedicos();
                    break;
                case 4:
                    MenuInternaçoes();
                    break;
                case 5:
                    MenuConsultas();
                    break; 
                case 6:
                    MenuRelatorios();
                    break;
                            case 0:
                                System.out.println("Saindo..");
                                return;
                            default:
                                System.out.println("Opção invalida.");
                                break;
                        }
                   
                
        }
    }
            

         public static void MenuPaciente()
        {
            
           
                while (true) 
                
                {
                    System.out.println("PARTICULAR.");           
                    System.out.println("Nome: ");
                    String Nome = scan.nextLine();
                    System.out.println("Idade: ");
                    int idade = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Cpf: ");
                    String cpf = scan.nextLine();
                    System.out.println("Saldo inicial: \n(Ex: 1500.0)");
                    Double saldo = null;
                    while (saldo == null) {
                        String saldoStr = scan.nextLine().replace(",", ".");
                        try {
                            saldo = Double.parseDouble(saldoStr);
                        } catch (NumberFormatException e) {
                            System.out.print("Valor invalido. Digite o saldo novamente (Ex: 1500.0): ");
                        }
                    }
                    Paciente Paci = new Paciente(Nome, idade, cpf, new ArrayList<>(),  new ArrayList<>(), saldo);
                    listapacientes.add(Paci);                
                    System.out.println("Paciente cadastrado.");
                    salvarPacientes();
                    break; 
                }
        }

        public static void MenuPacienteEspecial()
            {
                while (true) 
                {
                    System.out.println("Cadastramento de paciente especial:");           
                    System.out.println("Nome:");
                    String Nome = scan.nextLine();
                    System.out.println("Idade:");
                    int idade = scan.nextInt();
                    scan.nextLine();
                    System.out.println("Cpf");
                    String cpf = scan.nextLine();
                    System.out.println("Saldo inicial: \nEx: 1500.0");
                    Double saldo = null;
                    while (saldo == null) {
                        String saldoStr = scan.nextLine().replace(",", ".");
                        try {
                            saldo = Double.parseDouble(saldoStr);
                        } catch (NumberFormatException e) {
                            System.out.print("Valor invalido. Digite o saldo novamente (Ex: 1500.0): ");
                        }
                    }
                    System.out.println("Escolha o plano de saúde:");
                    PlanoS[] planos = PlanoS.values();

                    for (int i = 0; i < planos.length; i++) 
                    {
                    System.out.println(  i + " - " + planos[i] + " (" + (int)(planos[i].getDescontos() * 100) + "% de desconto)");
                    }

                    System.out.print("Digite o número do plano escolhido: ");
                    int planoIndex = scan.nextInt();

                    PlanoS planoEscolhido = planos[planoIndex];

    
                    PacienteEspecial pacienteEspecial = new PacienteEspecial(Nome, idade, cpf, saldo, new ArrayList<InternaçaoMotivos>(), new ArrayList<Historico>(), planoEscolhido);
                    listapacientes.add(pacienteEspecial);

                    System.out.println("Paciente especial cadastrado com sucesso.");
                    break;
                }
                   
            }
                    
                    
        public static void MenuMedicos()   
        {
            do{
                System.out.println("1 - Ver medicos cadastrados:");
                System.out.println("2 - Cadastrar medicos");
                System.out.println("0 - sair");
                int b = scan.nextInt();
                switch (b)
                {
                    case 1:
                                for (Medicos m : medcos){
                        m.dadosMedico();
                    
                            System.out.println("Dr.(a):" + m.getNome());
                            System.out.println("Especialidade" + m.getEspecialidades());
                            System.out.println("Custo da consulta com plano Amil: R$" + m.custo(PlanoS.AMIL));
                            System.out.println("Custo da consulta com plano Bradesco: R$" + m.custo(PlanoS.BRADESCO));
                            System.out.println("Custo da consulta com plano Hapvida: R$" + m.custo(PlanoS.HAPVIDA));
                            System.out.println("Custo da consulta com plano Sul America: R$" + m.custo(PlanoS.SUL_AMERICA));
            }
                    break;
                    case 2:
                    while(true)
                        {
                            System.out.println("Cadastro de medico:");
                            System.out.println("Nome:");
                            String nome = scan.nextLine();
                            System.out.println("CRM");
                            String CRM = scan.nextLine();
                            System.out.println("Especialidade:");
                            String especialidades = scan.nextLine();
                            System.out.println("Custo por consulta:");
                            Double custo = null;
                            while (custo == null) {
                                String custoStr = scan.nextLine().replace(",", ".");
                                try {
                                    custo = Double.parseDouble(custoStr);
                                    } catch (NumberFormatException e) {
                                        System.out.print("Valor inválido! Digite o custo novamente (Ex: 400.0): ");
                                    }
                                }
                            Medicos med = new Medicos(nome, CRM, especialidades, custo);
                            medcos.add(med);
                            System.out.println("Medico cadastrado!");
                            break;

                        } 
                    case 0:
                        System.out.println("sainDo..");
                        return;
                    default:
                        System.out.println("Opção invalida.");
                        

      }   }while(true); 
        }
                    
        public static void MenuInternaçoes()
        {
            do{
                System.out.println("1 - Ver internações:");
                System.out.println("2 - Cadastrar internação");
                System.out.println("3 - Liberar internação");
                System.out.println("0 - sair");
                
                int b = scan.nextInt();
                switch (b)
                {
                    case 1:
                        for (Internaçoes in : listainternados){
                            in.dadosInternado();
                            System.out.println("--------------------");
                        }
                    break;
                    case 2:
                        while(true)
                        {
                            System.out.println("Cadastro de internação:");
                            System.out.println("Escolha o paciente:");
                            for (int i = 0; i < listapacientes.size(); i++)
                            {
                                System.out.println(i + " - " + listapacientes.get(i).getNome());
                            }
                            int pIndex = scan.nextInt();
                            scan.nextLine();
                            Paciente paciente = listapacientes.get(pIndex);

                            System.out.println("Escolha o médico:");
                            for (int i = 0; i < medcos.size(); i++) {
                                System.out.println(i + " - " + medcos.get(i).getNome());
                                                            }
                            int mIndex = scan.nextInt();
                            scan.nextLine();
                            Medicos medico = medcos.get(mIndex);

                            System.out.println("Escolha a situação do paciente (ESTAVEL, INSTAVEL, CRITICO):");
                            String situacaoStr = scan.nextLine();
                            Situaçao situaçao = Situaçao.valueOf(situacaoStr);
                          
                            LocalDateTime entrada = LocalDateTime.now();
                            System.out.print("Data e hora da internaçao (yyyy-MM-dd HH:mm): ");
                            String dataStr = scan.nextLine();
                            LocalDateTime dataHora = null;
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                            while (dataHora == null) {
                                try {
                                    dataHora = LocalDateTime.parse(dataStr, formatter);
                                } catch (DateTimeParseException e) {
                                    System.out.print("Formato inválido! Digite novamente (yyyy-MM-dd HH:mm): ");
                                    dataStr = scan.nextLine();}}

                            System.out.println("Motivo da internação:");
                            String motivoStr = scan.nextLine();
                            ArrayList<String> diagnostico = new ArrayList<>();
                            diagnostico.add(motivoStr);

                            System.out.println("Local da internação (Opções: Sala_1, Sala_2, Sala_3, Sala_4, Sala_5, Sala_6, Sala_7):");
                            String local = scan.nextLine();
                            while (local == null) {
                                try {
                                    Salas locall = Salas.valueOf(local);
                                    } catch (IllegalArgumentException e) {
                                        System.out.print("Local inválido! Digite novamente (Opções: Sala_1, Sala_2, Sala_3, Sala_4, Sala_5, Sala_6, Sala_7): ");
                                        local = scan.nextLine();}}
                            

                            System.out.println("Valor da internação: Ex: 1500.0");
                            Double valorInterna = scan.nextDouble();
                            scan.nextLine();
                            Internaçoes internaçoes = new Internaçoes(paciente, medico, situaçao, entrada, null, diagnostico, Salas.valueOf(local), valorInterna);
                            listainternados.add(internaçoes);
                            
                            System.out.println("Internação cadastrada.");
                            break;
                        } 
                    
                case 3:
                System.out.println("Liberar internação:");
                System.out.println("Escolha o paciente para liberar:");
                for (int i = 0; i < listainternados.size(); i++) {
                    System.out.println(i + " - " + listainternados.get(i).getInternado().getNome());
                }
                int index = scan.nextInt();
                scan.nextLine();
                if (index >= 0 && index < listainternados.size()) {
                    Internaçoes internaçao = listainternados.get(index);
                    internaçao.setSaida(LocalDateTime.now());
                    internaçao.setSituaçao(Situaçao.CRITICO);
                    System.out.println("Internação liberada para o paciente: " + internaçao.getInternado().getNome());
                    listainternados.remove(index);
                }
                else if (b == 0)
                {
                    System.out.println("Saindo...");
                } 
                else 
                {
                    System.out.println("opção inválida.");
                }
                    case 0:
                        System.out.println("saindo..");
                        return;
                    default:
                        System.out.println("Opção invalida.");
                        break;    
                }
                
                if (listainternados.isEmpty())
                {
                    System.out.println("Nenhum paciente internado no momento.");
                }
                else
                {
                    System.out.println("Pacientes internados:");
                }
                    for (int i = 0; i < listainternados.size(); i++)
                    {
                    Internaçoes in = listainternados.get(i); 
                    {   
                    System.out.println("Internação " + (i + 1) + ":");
                    System.out.println("Paciente: " + in.getInternado().getNome());
                    System.out.println("Médico: " + in.getMedicos().getNome());
                    System.out.println("Motivo: " + in.getDiagnostico());
                    System.out.println("Sala" + in.getLocal());
                    System.out.println("Data da internação:" + in.getEntrada());
                    System.out.println("Situação: " + in.getSituaçao());
                    }       
                    
                }
            }while(true); 
                
        }

          /// 
          /// 
          
            public static void MenuConsultas()
            {
                System.out.println("Cadastrando a consulta...");

                for (int i = 0; i < listapacientes.size(); i++)
                {
                    System.out.println(i + " - " + listapacientes.get(i).getNome());
                }
                System.out.print("Escolha o paciente: ");
                int pIndex = scan.nextInt();
                scan.nextLine();
                Paciente paciente = listapacientes.get(pIndex);

                for (int i = 0; i < medcos.size(); i++) {
                    System.out.println(i + " - " + medcos.get(i).getNome());
                                                        }
                System.out.print("Escolha o medico: ");
                int mIndex = scan.nextInt();
                scan.nextLine();
                Medicos medico = medcos.get(mIndex);
            

                System.out.print("Digite data e hora da consulta (yyyy-MM-dd HH:mm): ");
                String dataStr = scan.nextLine();
                LocalDateTime dataHora = null;
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                while (dataHora == null) {
                    try {
                        dataHora = LocalDateTime.parse(dataStr, formatter);
                    } catch (DateTimeParseException e) {
                        System.out.print("formato invalido, digite novamente (yyyy-MM-dd HH:mm): ");
                        dataStr = scan.nextLine();
                    }
                }
                System.out.println("Local da consulta (opções):");
                for (Salas s : Salas.values()) {
                    System.out.println(" - " + s.name());
                }
                String local = scan.nextLine();
                Salas sala = Salas.valueOf(local);

                boolean choque = false;
                for (Consultas c : listaConsultas) 
                {
                    if (c.getData().equals(dataHora)) 
                    {
                        if ((c.getMedico() != null && c.getMedico().equals(medico)) || (c.getLocal() != null && c.getLocal().name().equalsIgnoreCase(local))) 
                        {
                            choque = true;
                            break;
                        }
                    }
                }
            
                if (choque) {
                    System.out.println("Choque de horário ou local. Consulta não agendada.");
                            } 
                else {
            System.out.println("Escolha o plano de saude do paciente especial:");
            PlanoS[] planos = PlanoS.values();
            for (int i = 0; i < planos.length; i++) 
            {
                System.out.println(i + " - " + planos[i] + " (" + (int)(planos[i].getDescontos()*100) + "% de desconto)");
            }
            System.out.print("Digite o numero do plano escolhido: ");
            int planoIndex = scan.nextInt();
            scan.nextLine();
            PlanoS planoEscolhido = planos[planoIndex];

            double valorConsulta = medico.custo(planoEscolhido);

            // Verifica saldo antes de agendar
            if (paciente.getSaldo() < valorConsulta) {
                System.out.println("Saldo insuficiente para agendar a consulta. Saldo atual: " + paciente.getSaldo() + ", valor da consulta: " + valorConsulta);
                return;
            }
            else
            {
                System.out.println("Agendando consulta..");
            }

            Consultas novaConsulta = new Consultas(
                paciente, medico, dataHora, Salas.valueOf(local), null,
                Confirmaçao.CONSULTA_AGENDADA, valorConsulta
            );
            listaConsultas.add(novaConsulta);
            
            paciente.setSaldo(paciente.getSaldo() - valorConsulta);

            System.out.println("Consulta agendada com sucesso!");
            System.out.println("Novo saldo do paciente: " + paciente.getSaldo());
        }
                     }
                public static void MenuRelatorios()
                {
                    do{
                        System.out.println("1 - Relatório de Pacientes:");
                        System.out.println("2 - Relatório de Médicos:");
                        System.out.println("3 - Relatório de Consultas:");
                        System.out.println("4 - Relatório de Internações:");
                        System.out.println("0 - sair");
                        
                        int b = scan.nextInt();
                        switch (b)
                        {
                            case 1:
                                for (Paciente p : listapacientes){
                                    if (p instanceof PacienteEspecial) {
                                        ((PacienteEspecial) p).dadosPacientesEspeciais();
                                    } else {
                                        p.dadosPacientes();
                                    }
                                    System.out.println("                 ");
                                }
                            break;
                            case 2:
                                for (Medicos m : medcos){
                                    m.dadosMedico();
                                    System.out.println("                  ");
                                }
                            break;
                            case 3:
                                for (Consultas c : listaConsultas){
                                    System.out.println(c.toString());
                                    System.out.println("                  ");
                                }
                            break;
                            case 4:
                                for (Internaçoes in : listainternados){
                                    in.dadosInternado();
                                    System.out.println("     ");
                                }
                            break;
                            case 0:
                                System.out.println("saindo..");
                                return;
                            default:
                                System.out.println("Opção invalida.");
                                break;    
                     } }while(true);        
                            
            } 
        
        public static void salvarPacientes() {
    try {
        FileWriter fw = new FileWriter("pacientes.txt");
        for (Paciente p : listapacientes) {
            if (p instanceof PacienteEspecial) {
                PacienteEspecial pe = (PacienteEspecial) p;
                fw.write("ESPECIAL;" + pe.getNome() + ";" + pe.getIdade() + ";" + pe.getCpf() + ";" + pe.getSaldo() + ";" + pe.getPlanodesaude() + "\n");
            } else {
                fw.write("NORMAL;" + p.getNome() + ";" + p.getIdade() + ";" + p.getCpf() + ";" + p.getSaldo() + "\n");
            }
        }
        fw.close();
        System.out.println("Pacientes salvos.");
    } catch (IOException e) {
        System.out.println("Erro ao salvar pacientes.");
    }
}
public static void carregarPacientes() {
    try {
        FileReader fr = new FileReader("pacientes.txt");
        BufferedReader br = new BufferedReader(fr);
        String linha;
        while ((linha = br.readLine()) != null) {
            String[] partes = linha.split(";");
            if (partes[0].equals("ESPECIAL")) {
                String nome = partes[1];
                int idade = Integer.parseInt(partes[2]);
                String cpf = partes[3];
                double saldo = Double.parseDouble(partes[4]);
                PlanoS plano = PlanoS.valueOf(partes[5]);
                PacienteEspecial pe = new PacienteEspecial(nome, idade, cpf, saldo, new ArrayList<>(), new ArrayList<>(), plano);
                listapacientes.add(pe);
            } else if (partes[0].equals("NORMAL")) {
                String nome = partes[1];
                int idade = Integer.parseInt(partes[2]);
                String cpf = partes[3];
                double saldo = Double.parseDouble(partes[4]);
                Paciente p = new Paciente(nome, idade, cpf, new ArrayList<>(), new ArrayList<>(), saldo);
                listapacientes.add(p);
            }
        }
        br.close();
        fr.close();
        System.out.println("Pacientes carregados.");
    } catch (IOException e) {
        System.out.println("Erro ao carregar pacientes.");
    }
}
    }