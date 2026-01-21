package br.com.mylena;

import br.com.mylena.dao.ClientMapDAO;
import br.com.mylena.dao.IClientDAO;
import br.com.mylena.domain.Client;

import javax.swing.*;

public class App {
    private static IClientDAO iClientDAO;

    public static void main(String args[]) {
        iClientDAO = new ClientMapDAO();

        String option = JOptionPane.showInputDialog(
                null,
                "Digite 1 para cadastro, 2 para consulta, 3 para excluir, 4 para alterar ou 5 para sair",
                "Menu",
                JOptionPane.INFORMATION_MESSAGE
        );

        if (option == null) {
            exit();
        }

        while (!isValidOption((option))) {
            if ("".equals(option)) {
                exit();
            } else {
                option = JOptionPane.showInputDialog(null, "Opção inválida. Digite 1 para " +
                        "cadastro, 2 para consulta, 3 para excluir, 4 para alterar ou 5 para sair", "Menu", JOptionPane.INFORMATION_MESSAGE);
            }
        }

        while (isValidOption(option)) {
            if (isExitOption(option)) {
                exit();
            } else if (isRegister(option)) {
                String data = JOptionPane.showInputDialog(null, "Digite os dados do cliente" +
                        "separados por vírgula. Ex: Nome, cpf, telefone, endereço, numero, cidade, estado", "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                Register(data);
            } else if (isSearch(option)) {
                String data = JOptionPane.showInputDialog(null, "Digite o CPF (somente numeros): ", "Consulta cliente por cpf", JOptionPane.INFORMATION_MESSAGE);
                Search(data);
            } else if (isDelete(option)) {
                String data = JOptionPane.showInputDialog(null, "Digite o CPF (somente numeros): ", "Excluir cliente", JOptionPane.INFORMATION_MESSAGE);
                Delete(data);
            } else {
                String data = JOptionPane.showInputDialog(null,
                        "Digite os dados do cliente separados por vígula, conforme exemplo: Nome, CPF, Telefone, Endereço, Número, Cidade e Estado",
                        "Atualização de cadastro", JOptionPane.INFORMATION_MESSAGE);
                Update(data);
            }
            option = JOptionPane.showInputDialog(null, "Digite 1 para cadastro, 2 para consulta, 3 para excluir, 4 para alterar ou 5 para sair", "Green dinner", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void Update(String data) {
        String[] splitData = data.split(",");
        Client newClient = new Client(splitData[0], splitData[1], splitData[2], splitData[3], splitData[4], splitData[5], splitData[6]);
        iClientDAO.update(newClient);
    }

    private static void Delete(String cpf) {
        Client client = iClientDAO.search(Long.parseLong(cpf));
        if (client != null) {
            iClientDAO.delete(Long.parseLong(cpf));
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso: " + client.toString(), "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado.", "Erro",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void Search(String cpf) {
        Client client = iClientDAO.search(Long.parseLong(cpf));
        if (client != null) {
            JOptionPane.showMessageDialog(null, "Cliente encontrado com sucesso: " + client.toString(), "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado", "ERRO",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void Register(String data) {
        String[] splitData = data.split(",", -1); // -1 mantém campos vazios no final
        int expectedFields = 7;
        String[] resultData = new String[expectedFields];

        for (int i = 0; i < expectedFields; i++) {
            if (i < splitData.length && !splitData[i].isBlank()) {
                resultData[i] = splitData[i];
            } else {
                resultData[i] = null;
            }
        }

        Client client = new Client(
                resultData[0],
                resultData[1],
                resultData[2],
                resultData[3],
                resultData[4],
                resultData[5],
                resultData[6]
        );

        Boolean registered = iClientDAO.register(client);

        if (registered) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "O CPF é obrigatório.", "ERRO DE CADASTRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static boolean isDelete(String option) {
        if ("3".equals(option)) {
            return true;
        }
        return false;
    }

    private static boolean isSearch(String option) {
        if ("2".equals(option)) {
            return true;
        }
        return false;
    }

    private static boolean isRegister(String option) {
        if ("1".equals(option)) {
            return true;
        }
        return false;
    }

    private static boolean isExitOption(String option) {
        if ("5".equals(option)) {
            return true;
        }
        return false;
    }

    private static void exit() {
        JOptionPane.showMessageDialog(null, "Até logo!", "Sair", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static boolean isValidOption(String option) {
        if ("1".equals(option)) {
            return true;
        } else if ("2".equals(option)) {
            return true;
        } else if ("3".equals(option)) {
            return true;
        } else if ("4".equals(option)) {
            return true;
        } else if ("5".equals(option)) {
            return true;
        }
        return false;
    }
}
