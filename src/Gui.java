import demo.JDBCXYChartDemo;
import demo.XYLineAndShapeRendererDemo1;

import javax.swing.*;
import javax.swing.Action;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Gui extends ControlPanel implements Runnable{
    private JButton addMarket;
    private JPanel panelMain;
    private JButton addAsset;
    private JButton showMarketsButton;
    private JButton addIndexorCompany;
    protected Semaphore semaphore = new Semaphore(1);
    private JDBCXYChartDemo f;




    // private List<Valute> Valute_list = new ArrayList<Valute>();


    public Gui() {
        Impementations impementations = new Impementations();

        //Gei gei = new Gei();

        addMarket.addActionListener(new ActionListener() { //dodawanie giełdy
            @Override
            public void actionPerformed(ActionEvent e) {
                //JOptionPane.showMessageDialog(null,"Hesdc");
                Object [] options = {"Value","Mineral","Paper","Cancel"};
                int n = JOptionPane.showOptionDialog(null,"Which market?", "Select",JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,null,options,options[3]);
                int k=1;
                switch (n){
                    case 0:
                        k=impementations.setMarket("v",countryList,valuteMarketList,marketList);
                        break;
                    case 1:
                        k=impementations.setMarket("m",countryList,mineralMarketList,marketList);
                        break;
                    case 2:
                        k=impementations.setMarket("p",countryList,paperMarketList,marketList);
                        break;
                    case 3:
                        break;
                }
                if(k!=0){
                    JOptionPane.showMessageDialog(null,
                            "You dont have any countries",
                            "Alert!",
                            JOptionPane.ERROR_MESSAGE);
                }
                System.out.println(n);
            }
        });
        addAsset.addActionListener(new ActionListener() { //dodawanie aktywa
            @Override
            public void actionPerformed(ActionEvent e) {
                //impementations.showAllValutes(Valute_list);
                Object [] options = {"Value","Mineral","Paper","Country","Cancel"};
                int n = JOptionPane.showOptionDialog(null,"Which asset?", "Select",JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,null,options,options[4]);
                int k;
                switch (n){
                    case 0:
                        k=impementations.setAsset("v",valuteList,assetList);
                        if(k!=0){
                            JOptionPane.showMessageDialog(null,
                                    "What do you want to make ? (type)",
                                    "Alert!",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 1:
                        k=impementations.setAsset("m",mineralList,assetList);
                        //System.out.println("tutaj rozmiar " + mineralList.size());
                        //System.out.println("wyzej rozmiar " + Gui.super.getMineralList().size());
                        //System.out.println("imie wyzej " + Gui.super.getName());
                        if(k!=0){
                            JOptionPane.showMessageDialog(null,
                                    "What do you want to make ? (type)",
                                    "Alert!",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 2:
                        break;
                    case 3:
                        k=impementations.setCountry(countryList,valuteList);
                        if(k!=0){
                            JOptionPane.showMessageDialog(null,
                                    "You dont have any Valute!",
                                    "Alert!",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 4:
                        break;
                }
                System.out.println(n);

            }
        });
        showMarketsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Gei gei = new Gei();
                //gei.cate();
                JFrame frame = new JFrame("JTable Test");
                //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                JTable table;
                JScrollPane scrollPane;
                Object [] options = {"Value","Mineral","Paper","Cancel"};
                int n = JOptionPane.showOptionDialog(null,"Which asset?", "Select",JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,null,options,options[2]);
                switch (n){
                    case 0:
                        table = createAssetTable('v', valuteList);
                        scrollPane = new JScrollPane(table);
                        frame.getContentPane().add(scrollPane);
                        frame.pack();
                        frame.setVisible(true);
                        break;
                    case 1:
                        table = createAssetTable('m',mineralList);
                        scrollPane = new JScrollPane(table);
                        frame.getContentPane().add(scrollPane);
                        frame.pack();
                        frame.setVisible(true);
                        break;
                    case 2:
                        table = createCompanyTable('m',companyList);
                        scrollPane = new JScrollPane(table);
                        frame.getContentPane().add(scrollPane);
                        frame.pack();
                        frame.setVisible(true);
                        break;
                }
                /*table.addMouseListener(new java.awt.event.MouseAdapter() {
                    @Override
                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        int row = table.rowAtPoint(evt.getPoint());
                        int col = table.columnAtPoint(evt.getPoint());
                        if (row >= 0 && col >= 0) {
                            //System.out.println(row+" "+col);
                            //showDiagram()
                        }
                    }
                });*/
            }
        });

        addIndexorCompany.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object [] options = {"Index","Company","Cancel"};
                int n = JOptionPane.showOptionDialog(null,"Which asset?", "Select",JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,null,options,options[2]);
                int k;
                switch (n){
                    case 0:
                        k=impementations.setIndex(indexList,paperMarketList);
                        if(k!=0){
                            JOptionPane.showMessageDialog(null,
                                    "first Create PaperMarket ? (type)",
                                    "Alert!",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                    case 1:
                        k=impementations.setCompany(companyList,indexList);
                        if(k!=0){
                            JOptionPane.showMessageDialog(null,
                                    "first Create Index ? (type)",
                                    "Alert!",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                        break;
                }
            }
        });
    }

    public JTable createAssetTable(char a, List<Asset> assetList){
        String[] columnNames = {"name", "value", "max value", "min value"};
        //Object[][] data ={{"sfssv","sadcasvd","vasd","SD s d"},{"sfssv","sadcasvd","vasd","SD s d"}};
        Object[][] data = new Object[assetList.size()][4];
        for(int i=0;i<assetList.size();i++){
            data[i] = new Object[4];
            data[i][0] = assetList.get(i).get_name();
            data[i][1] = assetList.get(i).get_actual_value();
            data[i][2] = assetList.get(i).getMaximum_value();
            data[i][3] = assetList.get(i).getMinimal_value();
        }

        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    System.out.println(row+" "+col);
                    //showDiagram()
                }
            }
        });
        return table;
    }

    public JTable createCompanyTable(char a, List<Company> assetList){
        String[] columnNames = {"name", "index", "act value","max value", "min value","total actions","opening course"};
        //Object[][] data ={{"sfssv","sadcasvd","vasd","SD s d"},{"sfssv","sadcasvd","vasd","SD s d"}};
        Object[][] data = new Object[assetList.size()][4];
        for(int i=0;i<assetList.size();i++){
            data[i] = new Object[7];
            data[i][0] = assetList.get(i).getName();
            data[i][1] = assetList.get(i).getIdex().getName();
            data[i][2] = assetList.get(i).getActual_course();
            data[i][3] = assetList.get(i).getMaximal_course();
            data[i][4] = assetList.get(i).getMinimal_course();
            data[i][5] = assetList.get(i).getTotal_actions();
            data[i][6] = assetList.get(i).getOpening_course();
        }

        JTable table = new JTable(data, columnNames);
        table.setFillsViewportHeight(true);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table.rowAtPoint(evt.getPoint());
                int col = table.columnAtPoint(evt.getPoint());
                if (row >= 0 && col >= 0) {
                    System.out.println(row+" "+col);
                    //showDiagram()
                }
            }
        });
        return table;
    }

    public boolean CountInverstor2Create(int a, int i,int k){
        //System.out.println("wynik to: " + a + " " + i);
        //System.out.println(a/3-i);
        if( ((int)(a/k) -i)>0){
            return true;
        }
        return false;
    }

    public void cate(String [] args){
        //this.mineralList=mineralList;
        JFrame frame = new JFrame("Gui");
        Gui gui = new Gui();
        frame.setContentPane(gui.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        Impementations impementations = new Impementations();

        /*impementations.setAsset("v",valuteList,assetList);
        impementations.setCountry(countryList,valuteList);
        impementations.setMarket("v",countryList,valuteMarketList,marketList);
        impementations.Asset2Market(valuteList,valuteMarketList);
        Investor investor= new Investor(assetList);
        InvestingCapital investingCapital = new InvestingCapital(valuteList);
        System.out.println(investingCapital.getInvesting_budget()); System.out.println(investingCapital.Buy(impementations.chooseAsset(valuteList))); System.out.println(investingCapital.getInvesting_budget());
        investingCapital.showAllUP();*/
        //System.out.println(investor.get_budget()); System.out.println(investor.Buy(impementations.chooseAsset(valuteList))); System.out.println(investor.get_budget());

        while (true){
            this.mineralList=gui.getMineralList();
            this.mineralMarketList=gui.getMineralMarketList();
            impementations.Asset2Market(this.mineralList,this.mineralMarketList);
            gui.setMineralList(this.mineralList);
            gui.setMineralMarketList(this.mineralMarketList);
            this.valuteList=gui.getValuteList();
            this.valuteMarketList=gui.getValuteMarketList();
            impementations.Asset2Market(this.valuteList,this.valuteMarketList);
            gui.setValuteList(this.valuteList);
            gui.setValuteMarketList(this.valuteMarketList);
            this.assetList=gui.getAssetList();

            this.paperMarketList=gui.getPaperMarketList();
            this.indexList=gui.getIndexList();
            this.companyList=gui.getCompanyList();

            //gui.AssetsWithOwner();

            if(CountInverstor2Create(this.getAssetList().size(),this.investorList.size(),3)){
                System.out.println("investore");
                Investor investor = new Investor(this.semaphore,gui.getAssetList(),this.companyList,this.investingCapitalList);
                this.addInvestor(investor);
                new Thread(investor).start();
            }
            if(CountInverstor2Create(this.getAssetList().size(),this.investingCapitalList.size(),6)){
                System.out.println("investore Capitale");
                InvestingCapital investingCapital = new InvestingCapital(this.semaphore,gui.getAssetList(),this.companyList);
                this.investingCapitalList.add(investingCapital);
                new Thread(investingCapital).start();
                break;
            }

        }

    }


    public void addInvestor(Investor investor){
        this.investorList.add(investor);
    }


}
