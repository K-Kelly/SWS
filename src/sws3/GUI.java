/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUI.java
 *
 * Created on Mar 23, 2011, 12:33:09 AM
 */
package sws3;

import java.awt.Color;
import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetListener;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.TreeSet;

import javax.swing.*;

/**
 *
 * @author Kevin
 */
public class GUI extends javax.swing.JFrame {

    /** Creates new form GUI */
    ArrayList<JFormattedTextField> list;
    FileHandler fH;
    League league;
    TreeSet<Player> playerSet;
    Player foundPlayer = null;
    ArrayList<Team> teamList;
    long salaryCap = 51500000;
    DefaultListModel from = new DefaultListModel();
    DefaultListModel copy = new DefaultListModel();
    DefaultListModel move = new DefaultListModel();

    public GUI() {
        initComponents();
        list = new ArrayList<JFormattedTextField>();
        fH = new FileHandler(new File("C://Program Files (x86)/Eastside Hockey Manager/saves/simplaying/players.ehm"));
        fH.readFromPlayersFile();
        league = new League(fH.getSortedPlayers(), salaryCap);
        league.createTeamMap();
        teamList = league.createTeams();
        playerSet = fH.getSortedPlayers();
        System.out.println("Num Players: " + playerSet.size());
        playerTab.setMnemonicAt(0, KeyEvent.VK_1);
        playerTab.setMnemonicAt(1, KeyEvent.VK_2);
        playerTab.setMnemonicAt(2, KeyEvent.VK_3);
        playerTab.setMnemonicAt(3, KeyEvent.VK_4);
        // createDraftList();
        //create list
        list.add(wGP);
        list.add(wG);
        list.add(wA);
        list.add(wP);
        list.add(wGWG);
        list.add(mGP);
        list.add(mG);
        list.add(mA);
        list.add(mP);
        list.add(mGWG);
        list.add(careerG);
        list.add(careerA);
        list.add(careerP);
        list.add(curStreakG);
        list.add(curStreakP);
        list.add(curStreakGP);
        list.add(bStreakGP);
        list.add(bStreakGWG);
        list.add(bStreakA);
        list.add(bStreakP);
        list.add(bStreakG);
        ///19
        list.add(mainPOSI);
        list.add(altPOSI);
        list.add(rightsField);
        list.add(draftYr);
        list.add(draftRd);
        list.add(draftPos);
        list.add(draftTeam);
        list.add(salaryYr);
        list.add(salaryAmt);
        list.add(height);
        list.add(weight);
        list.add(age);
        list.add(twoWay);
        list.add(country);
        list.add(hand);
        list.add(click);
        list.add(curSHO);
        list.add(curPLA);
        list.add(curSTK);
        list.add(curCHK);
        list.add(curPOS);
        list.add(curHIT);
        list.add(curSKA);
        list.add(curEND);
        list.add(curPEN);
        list.add(curFAC);
        list.add(curLEA);
        list.add(curFIG);
        list.add(curSTR);
        list.add(POT);
        list.add(CON);
        list.add(GRD);
        list.add(INJ);
        list.add(curOF);
        list.add(curDF);
        list.add(curOA);
        list.add(salaryAmtConsidering);
        list.add(salaryYrConsidering);
        list.add(ceilSHO);
        list.add(ceilPLA);
        list.add(ceilSTK);
        list.add(ceilCHK);
        list.add(ceilPOS);
        list.add(ceilHIT);
        list.add(ceilSKA);
        list.add(ceilEND);
        list.add(ceilPEN);
        list.add(ceilFAC);
        list.add(ceilLEA);
        list.add(ceilFIG);
        list.add(ceilSTR);
        list.add(ceilSHO1);
        list.add(ceilPLA1);
        list.add(ceilSTK1);
        list.add(ceilCHK1);
        list.add(ceilPOS1);
        list.add(ceilHIT1);
        list.add(ceilSKA1);
        list.add(ceilEND1);
        list.add(ceilPEN1);
        list.add(ceilFAC1);
        list.add(ceilLEA1);
        list.add(ceilFIG1);
        list.add(ceilSTR1);
        list.add(projOF);
        list.add(projDF);
        list.add(projOA);
        list.add(trainOF);
        list.add(trainDF);
        list.add(trainOA);
        list.add(farmOF1);
        list.add(farmDF1);
        list.add(farmOA1);
        list.add(status);

        //from, copy, move
        draftBestAvailable.setModel(from);
        draftBestAvailable.setTransferHandler(new FromTransferHandler());
        //draftBestAvailable.setPrototypeCellValue("List Item WWWWWW");
        draftBestAvailable.setDragEnabled(true);
        draftBestAvailable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        myDraftList.setModel(move);
        myDraftList.setTransferHandler(new ToTransferHandler(TransferHandler.COPY));
        myDraftList.setDropMode(DropMode.INSERT);
        myDraftList.setDragEnabled(true);
        //JList copyTo = new JList(copy);
        //copyTo.setTransferHandler(new ToTransferHandler(TransferHandler.MOVE));
        //copyTo.setDropMode(DropMode.INSERT);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        playerTab = new javax.swing.JTabbedPane();
        proListLabel = new javax.swing.JPanel();
        teamSearchField = new javax.swing.JTextField();
        teamSearchButton = new javax.swing.JButton();
        teamIcon = new javax.swing.JLabel();
        proSalaryLabel = new javax.swing.JLabel();
        farmSalaryLabel = new javax.swing.JLabel();
        farmSalary = new javax.swing.JFormattedTextField();
        proSalary = new javax.swing.JFormattedTextField();
        numPlayersLabel = new javax.swing.JLabel();
        numPlayers = new javax.swing.JFormattedTextField();
        proOFLabel = new javax.swing.JLabel();
        proDFLabel = new javax.swing.JLabel();
        proOALabel = new javax.swing.JLabel();
        proOffense = new javax.swing.JFormattedTextField();
        proDefense = new javax.swing.JFormattedTextField();
        proOA = new javax.swing.JFormattedTextField();
        numPlayersLabel1 = new javax.swing.JLabel();
        numPlayersLabel2 = new javax.swing.JLabel();
        numPlayersLabel3 = new javax.swing.JLabel();
        numPlayersPro = new javax.swing.JFormattedTextField();
        numPlayersFarm = new javax.swing.JFormattedTextField();
        numPlayersProsp = new javax.swing.JFormattedTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        lwList = new javax.swing.JList();
        lwListLabel = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        cList = new javax.swing.JList();
        cListLabel = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        rwList = new javax.swing.JList();
        rwListLabel = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        dList = new javax.swing.JList();
        dListLabel = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        gList = new javax.swing.JList();
        gListLabel = new javax.swing.JLabel();
        linesLabel = new javax.swing.JLabel();
        lwLine1 = new javax.swing.JFormattedTextField();
        lwLine2 = new javax.swing.JFormattedTextField();
        lwLine3 = new javax.swing.JFormattedTextField();
        lwLine4 = new javax.swing.JFormattedTextField();
        cLine1 = new javax.swing.JFormattedTextField();
        cLine2 = new javax.swing.JFormattedTextField();
        cLine3 = new javax.swing.JFormattedTextField();
        cLine4 = new javax.swing.JFormattedTextField();
        rwLine1 = new javax.swing.JFormattedTextField();
        rwLine2 = new javax.swing.JFormattedTextField();
        rwLine3 = new javax.swing.JFormattedTextField();
        rwLine4 = new javax.swing.JFormattedTextField();
        gStarting = new javax.swing.JFormattedTextField();
        gBackup = new javax.swing.JFormattedTextField();
        dpair1L = new javax.swing.JFormattedTextField();
        dpair1R = new javax.swing.JFormattedTextField();
        dPair2R = new javax.swing.JFormattedTextField();
        dpair2L = new javax.swing.JFormattedTextField();
        dpair3R = new javax.swing.JFormattedTextField();
        dpair3L = new javax.swing.JFormattedTextField();
        linesTacticsLabel = new javax.swing.JLabel();
        timeLine1 = new javax.swing.JFormattedTextField();
        timeLine2 = new javax.swing.JFormattedTextField();
        timeLine3 = new javax.swing.JFormattedTextField();
        timeLine4 = new javax.swing.JFormattedTextField();
        proTeamButton = new javax.swing.JRadioButton();
        farmTeamButton = new javax.swing.JRadioButton();
        prospectsButton = new javax.swing.JRadioButton();
        allButton = new javax.swing.JRadioButton();
        TacticsLine1 = new javax.swing.JComboBox();
        TacticsPP1 = new javax.swing.JComboBox();
        timePP2 = new javax.swing.JFormattedTextField();
        lwLinePP1 = new javax.swing.JFormattedTextField();
        lwLinePP2 = new javax.swing.JFormattedTextField();
        cLinePP2 = new javax.swing.JFormattedTextField();
        cLinePP1 = new javax.swing.JFormattedTextField();
        rwLinePP2 = new javax.swing.JFormattedTextField();
        rwLinePP1 = new javax.swing.JFormattedTextField();
        dpairLPP1 = new javax.swing.JFormattedTextField();
        dpairRPP1 = new javax.swing.JFormattedTextField();
        dPairRPP2 = new javax.swing.JFormattedTextField();
        dpairLPP2 = new javax.swing.JFormattedTextField();
        timePP1 = new javax.swing.JFormattedTextField();
        TacticsPP2 = new javax.swing.JComboBox();
        rwPK1 = new javax.swing.JFormattedTextField();
        dPairRPK1 = new javax.swing.JFormattedTextField();
        dpairLPK1 = new javax.swing.JFormattedTextField();
        lwPK1 = new javax.swing.JFormattedTextField();
        TacticsLine2 = new javax.swing.JComboBox();
        TacticsLine3 = new javax.swing.JComboBox();
        TacticsLine4 = new javax.swing.JComboBox();
        linesLabel1 = new javax.swing.JLabel();
        linesLabel2 = new javax.swing.JLabel();
        dPairRPK2 = new javax.swing.JFormattedTextField();
        rwPK2 = new javax.swing.JFormattedTextField();
        lwPK2 = new javax.swing.JFormattedTextField();
        dpairLPK2 = new javax.swing.JFormattedTextField();
        linesLabel3 = new javax.swing.JLabel();
        linesLabel4 = new javax.swing.JLabel();
        TacticsPK1 = new javax.swing.JComboBox();
        timePK1 = new javax.swing.JFormattedTextField();
        TacticsPK2 = new javax.swing.JComboBox();
        timePK2 = new javax.swing.JFormattedTextField();
        linesLabel5 = new javax.swing.JLabel();
        createLinesButton = new javax.swing.JButton();
        draftTab = new javax.swing.JPanel();
        draftYearList = new javax.swing.JComboBox();
        cListLabel1 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        draftCList = new javax.swing.JList();
        lwListLabel1 = new javax.swing.JLabel();
        dListLabel1 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        draftDList = new javax.swing.JList();
        rwListLabel1 = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        draftRwList = new javax.swing.JList();
        gListLabel1 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        draftGList = new javax.swing.JList();
        jScrollPane14 = new javax.swing.JScrollPane();
        draftLwList = new javax.swing.JList();
        draftOFLabel = new javax.swing.JLabel();
        draftOALabel = new javax.swing.JLabel();
        draftDLabel = new javax.swing.JLabel();
        draftDLabel1 = new javax.swing.JLabel();
        draftOALabel1 = new javax.swing.JLabel();
        draftOFLabel1 = new javax.swing.JLabel();
        draftOALabel2 = new javax.swing.JLabel();
        draftDLabel2 = new javax.swing.JLabel();
        draftOFLabel2 = new javax.swing.JLabel();
        numPlayersDraft = new javax.swing.JFormattedTextField();
        numPlayersLabel4 = new javax.swing.JLabel();
        draftOF = new javax.swing.JFormattedTextField();
        draftDF = new javax.swing.JFormattedTextField();
        draftOA = new javax.swing.JFormattedTextField();
        draftPOF = new javax.swing.JFormattedTextField();
        draftPDF = new javax.swing.JFormattedTextField();
        draftPOA = new javax.swing.JFormattedTextField();
        draftTOF = new javax.swing.JFormattedTextField();
        draftTDF = new javax.swing.JFormattedTextField();
        draftTOA = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        draftOA1 = new javax.swing.JFormattedTextField();
        draftPOF1 = new javax.swing.JFormattedTextField();
        draftOF1 = new javax.swing.JFormattedTextField();
        draftDF1 = new javax.swing.JFormattedTextField();
        draftTOA1 = new javax.swing.JFormattedTextField();
        draftTOF1 = new javax.swing.JFormattedTextField();
        draftTDF1 = new javax.swing.JFormattedTextField();
        draftPDF1 = new javax.swing.JFormattedTextField();
        draftPOA1 = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        draftOF2 = new javax.swing.JFormattedTextField();
        draftTOA2 = new javax.swing.JFormattedTextField();
        draftDF2 = new javax.swing.JFormattedTextField();
        draftTDF2 = new javax.swing.JFormattedTextField();
        draftTOF2 = new javax.swing.JFormattedTextField();
        draftPOA2 = new javax.swing.JFormattedTextField();
        draftPDF2 = new javax.swing.JFormattedTextField();
        draftPOF2 = new javax.swing.JFormattedTextField();
        draftOA2 = new javax.swing.JFormattedTextField();
        draftPOF3 = new javax.swing.JFormattedTextField();
        draftOA3 = new javax.swing.JFormattedTextField();
        draftPOA3 = new javax.swing.JFormattedTextField();
        draftPDF3 = new javax.swing.JFormattedTextField();
        draftTDF3 = new javax.swing.JFormattedTextField();
        draftTOF3 = new javax.swing.JFormattedTextField();
        draftTOA3 = new javax.swing.JFormattedTextField();
        draftDF3 = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        draftOF3 = new javax.swing.JFormattedTextField();
        draftPOF4 = new javax.swing.JFormattedTextField();
        draftOA4 = new javax.swing.JFormattedTextField();
        draftPOA4 = new javax.swing.JFormattedTextField();
        draftPDF4 = new javax.swing.JFormattedTextField();
        draftTDF4 = new javax.swing.JFormattedTextField();
        draftTOF4 = new javax.swing.JFormattedTextField();
        draftTOA4 = new javax.swing.JFormattedTextField();
        draftDF4 = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        draftOF4 = new javax.swing.JFormattedTextField();
        draftPOF5 = new javax.swing.JFormattedTextField();
        draftOA5 = new javax.swing.JFormattedTextField();
        draftPOA5 = new javax.swing.JFormattedTextField();
        draftPDF5 = new javax.swing.JFormattedTextField();
        draftTDF5 = new javax.swing.JFormattedTextField();
        draftTOF5 = new javax.swing.JFormattedTextField();
        draftTOA5 = new javax.swing.JFormattedTextField();
        draftDF5 = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        draftOF5 = new javax.swing.JFormattedTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        draftBestAvailable = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        myDraftList = new javax.swing.JList();
        bestAvailableLabel = new javax.swing.JLabel();
        draftQueue = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        queueButton = new javax.swing.JButton();
        playerPanel = new javax.swing.JPanel();
        playerIcon = new javax.swing.JLabel();
        searchField = new javax.swing.JTextField();
        searchPlayer = new javax.swing.JButton();
        mainPOSI = new javax.swing.JFormattedTextField();
        altPOSI = new javax.swing.JFormattedTextField();
        rightsField = new javax.swing.JFormattedTextField();
        rightsLabel = new javax.swing.JLabel();
        draftLabel = new javax.swing.JLabel();
        draftYr = new javax.swing.JFormattedTextField();
        draftRd = new javax.swing.JFormattedTextField();
        draftPos = new javax.swing.JFormattedTextField();
        draftTeam = new javax.swing.JFormattedTextField();
        draftTeamLabel = new javax.swing.JLabel();
        draftHeaderLabel = new javax.swing.JLabel();
        salaryYr = new javax.swing.JFormattedTextField();
        salaryAmt = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        salaryAmtLabel = new javax.swing.JLabel();
        salaryYrLabel = new javax.swing.JLabel();
        heightLabel = new javax.swing.JLabel();
        height = new javax.swing.JFormattedTextField();
        weightLabel = new javax.swing.JLabel();
        weight = new javax.swing.JFormattedTextField();
        ageLabel = new javax.swing.JLabel();
        age = new javax.swing.JFormattedTextField();
        twoWay = new javax.swing.JFormattedTextField();
        twoWayLabel = new javax.swing.JLabel();
        countryLabel = new javax.swing.JLabel();
        country = new javax.swing.JFormattedTextField();
        hand = new javax.swing.JFormattedTextField();
        handLabel = new javax.swing.JLabel();
        clickLabel = new javax.swing.JLabel();
        click = new javax.swing.JFormattedTextField();
        shoLabel = new javax.swing.JLabel();
        plaLabel = new javax.swing.JLabel();
        stkLabel = new javax.swing.JLabel();
        chkLabel = new javax.swing.JLabel();
        posLabel = new javax.swing.JLabel();
        hitLabel = new javax.swing.JLabel();
        skaLabel = new javax.swing.JLabel();
        endLabel = new javax.swing.JLabel();
        penLabel = new javax.swing.JLabel();
        facLabel = new javax.swing.JLabel();
        leaLabel = new javax.swing.JLabel();
        figLabel = new javax.swing.JLabel();
        strLabel = new javax.swing.JLabel();
        potLabel = new javax.swing.JLabel();
        conLabel = new javax.swing.JLabel();
        grdLabel = new javax.swing.JLabel();
        injLabel = new javax.swing.JLabel();
        ofLabel = new javax.swing.JLabel();
        dfLabel = new javax.swing.JLabel();
        oaLabel = new javax.swing.JLabel();
        curSHO = new javax.swing.JFormattedTextField();
        curPLA = new javax.swing.JFormattedTextField();
        curSTK = new javax.swing.JFormattedTextField();
        curCHK = new javax.swing.JFormattedTextField();
        curPOS = new javax.swing.JFormattedTextField();
        curHIT = new javax.swing.JFormattedTextField();
        curSKA = new javax.swing.JFormattedTextField();
        curEND = new javax.swing.JFormattedTextField();
        curPEN = new javax.swing.JFormattedTextField();
        curFAC = new javax.swing.JFormattedTextField();
        curLEA = new javax.swing.JFormattedTextField();
        curFIG = new javax.swing.JFormattedTextField();
        curSTR = new javax.swing.JFormattedTextField();
        POT = new javax.swing.JFormattedTextField();
        CON = new javax.swing.JFormattedTextField();
        GRD = new javax.swing.JFormattedTextField();
        INJ = new javax.swing.JFormattedTextField();
        curOF = new javax.swing.JFormattedTextField();
        curDF = new javax.swing.JFormattedTextField();
        curOA = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        salaryAmtConsidering = new javax.swing.JFormattedTextField();
        salaryYrConsidering = new javax.swing.JFormattedTextField();
        salaryYrLabelConsidering = new javax.swing.JLabel();
        salaryAmtLabelConsidering = new javax.swing.JLabel();
        ConsideringLabel = new javax.swing.JLabel();
        ceilingLabel = new javax.swing.JLabel();
        ceilSHO = new javax.swing.JFormattedTextField();
        ceilPLA = new javax.swing.JFormattedTextField();
        ceilSTK = new javax.swing.JFormattedTextField();
        ceilCHK = new javax.swing.JFormattedTextField();
        ceilPOS = new javax.swing.JFormattedTextField();
        ceilHIT = new javax.swing.JFormattedTextField();
        ceilSKA = new javax.swing.JFormattedTextField();
        ceilEND = new javax.swing.JFormattedTextField();
        ceilPEN = new javax.swing.JFormattedTextField();
        ceilFAC = new javax.swing.JFormattedTextField();
        ceilLEA = new javax.swing.JFormattedTextField();
        ceilFIG = new javax.swing.JFormattedTextField();
        ceilSTR = new javax.swing.JFormattedTextField();
        ceilSHO1 = new javax.swing.JFormattedTextField();
        ceilPLA1 = new javax.swing.JFormattedTextField();
        ceilSTK1 = new javax.swing.JFormattedTextField();
        ceilCHK1 = new javax.swing.JFormattedTextField();
        ceilPOS1 = new javax.swing.JFormattedTextField();
        ceilHIT1 = new javax.swing.JFormattedTextField();
        ceilSKA1 = new javax.swing.JFormattedTextField();
        ceilEND1 = new javax.swing.JFormattedTextField();
        ceilPEN1 = new javax.swing.JFormattedTextField();
        ceilFAC1 = new javax.swing.JFormattedTextField();
        ceilLEA1 = new javax.swing.JFormattedTextField();
        ceilFIG1 = new javax.swing.JFormattedTextField();
        ceilSTR1 = new javax.swing.JFormattedTextField();
        ceilingLabel1 = new javax.swing.JLabel();
        projOF = new javax.swing.JFormattedTextField();
        projDF = new javax.swing.JFormattedTextField();
        projOA = new javax.swing.JFormattedTextField();
        trainOF = new javax.swing.JFormattedTextField();
        trainDF = new javax.swing.JFormattedTextField();
        trainOA = new javax.swing.JFormattedTextField();
        ceilingLabel2 = new javax.swing.JLabel();
        farmOF1 = new javax.swing.JFormattedTextField();
        farmDF1 = new javax.swing.JFormattedTextField();
        farmOA1 = new javax.swing.JFormattedTextField();
        ceilingLabel3 = new javax.swing.JLabel();
        status = new javax.swing.JFormattedTextField();
        statusLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        similarPlayerList = new javax.swing.JList();
        weeklyLabel = new javax.swing.JLabel();
        shoLabel1 = new javax.swing.JLabel();
        gLabel = new javax.swing.JLabel();
        assistLabel = new javax.swing.JLabel();
        pLabel = new javax.swing.JLabel();
        gwgLabel = new javax.swing.JLabel();
        wGP = new javax.swing.JFormattedTextField();
        wG = new javax.swing.JFormattedTextField();
        wA = new javax.swing.JFormattedTextField();
        wP = new javax.swing.JFormattedTextField();
        wGWG = new javax.swing.JFormattedTextField();
        weeklyLabel1 = new javax.swing.JLabel();
        mGP = new javax.swing.JFormattedTextField();
        mG = new javax.swing.JFormattedTextField();
        mA = new javax.swing.JFormattedTextField();
        mP = new javax.swing.JFormattedTextField();
        mGWG = new javax.swing.JFormattedTextField();
        weeklyLabel2 = new javax.swing.JLabel();
        curStreakGP = new javax.swing.JFormattedTextField();
        curStreakG = new javax.swing.JFormattedTextField();
        curStreakP = new javax.swing.JFormattedTextField();
        weeklyLabel3 = new javax.swing.JLabel();
        bStreakGP = new javax.swing.JFormattedTextField();
        bStreakG = new javax.swing.JFormattedTextField();
        bStreakA = new javax.swing.JFormattedTextField();
        bStreakP = new javax.swing.JFormattedTextField();
        bStreakGWG = new javax.swing.JFormattedTextField();
        careerG = new javax.swing.JFormattedTextField();
        careerA = new javax.swing.JFormattedTextField();
        careerP = new javax.swing.JFormattedTextField();
        weeklyLabel4 = new javax.swing.JLabel();
        similarPlayerLabel = new javax.swing.JLabel();
        playerID = new javax.swing.JLabel();
        playerTypeP1 = new javax.swing.JFormattedTextField();
        playerTypeP2 = new javax.swing.JFormattedTextField();
        comparePlayersTab = new javax.swing.JPanel();
        comparePlayerField1 = new javax.swing.JTextField();
        comparePlayerField2 = new javax.swing.JTextField();
        comparePlayerButton = new javax.swing.JButton();
        stkLabel1 = new javax.swing.JLabel();
        plaLabel1 = new javax.swing.JLabel();
        skaLabel1 = new javax.swing.JLabel();
        hitLabel1 = new javax.swing.JLabel();
        posLabel1 = new javax.swing.JLabel();
        chkLabel1 = new javax.swing.JLabel();
        projSTR1 = new javax.swing.JFormattedTextField();
        projFIG1 = new javax.swing.JFormattedTextField();
        projFAC1 = new javax.swing.JFormattedTextField();
        projSKA1 = new javax.swing.JFormattedTextField();
        projHIT1 = new javax.swing.JFormattedTextField();
        projSTK1 = new javax.swing.JFormattedTextField();
        projPOS1 = new javax.swing.JFormattedTextField();
        projCHK1 = new javax.swing.JFormattedTextField();
        projPLA1 = new javax.swing.JFormattedTextField();
        projSHO1 = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        projDF1 = new javax.swing.JFormattedTextField();
        ceilingLabel4 = new javax.swing.JLabel();
        projOF1 = new javax.swing.JFormattedTextField();
        curLEA1 = new javax.swing.JFormattedTextField();
        curFAC1 = new javax.swing.JFormattedTextField();
        shoLabel2 = new javax.swing.JLabel();
        curSTR1 = new javax.swing.JFormattedTextField();
        curFIG1 = new javax.swing.JFormattedTextField();
        POT1 = new javax.swing.JFormattedTextField();
        CON1 = new javax.swing.JFormattedTextField();
        GRD1 = new javax.swing.JFormattedTextField();
        INJ1 = new javax.swing.JFormattedTextField();
        curOF1 = new javax.swing.JFormattedTextField();
        curDF1 = new javax.swing.JFormattedTextField();
        curOA1 = new javax.swing.JFormattedTextField();
        curSTK1 = new javax.swing.JFormattedTextField();
        curPLA1 = new javax.swing.JFormattedTextField();
        curSHO1 = new javax.swing.JFormattedTextField();
        oaLabel1 = new javax.swing.JLabel();
        dfLabel1 = new javax.swing.JLabel();
        curEND1 = new javax.swing.JFormattedTextField();
        curPEN1 = new javax.swing.JFormattedTextField();
        curHIT1 = new javax.swing.JFormattedTextField();
        curSKA1 = new javax.swing.JFormattedTextField();
        curCHK1 = new javax.swing.JFormattedTextField();
        curPOS1 = new javax.swing.JFormattedTextField();
        strLabel1 = new javax.swing.JLabel();
        figLabel1 = new javax.swing.JLabel();
        penLabel1 = new javax.swing.JLabel();
        endLabel1 = new javax.swing.JLabel();
        leaLabel1 = new javax.swing.JLabel();
        facLabel1 = new javax.swing.JLabel();
        conLabel1 = new javax.swing.JLabel();
        grdLabel1 = new javax.swing.JLabel();
        injLabel1 = new javax.swing.JLabel();
        ofLabel1 = new javax.swing.JLabel();
        potLabel1 = new javax.swing.JLabel();
        projOA1 = new javax.swing.JFormattedTextField();
        salaryYrLabel1 = new javax.swing.JLabel();
        salaryAmt1 = new javax.swing.JFormattedTextField();
        salaryYr1 = new javax.swing.JFormattedTextField();
        salaryAmtLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        trainOA1 = new javax.swing.JFormattedTextField();
        ceilingLabel5 = new javax.swing.JLabel();
        trainOF1 = new javax.swing.JFormattedTextField();
        trainDF1 = new javax.swing.JFormattedTextField();
        farmOF2 = new javax.swing.JFormattedTextField();
        farmDF2 = new javax.swing.JFormattedTextField();
        ceilingLabel6 = new javax.swing.JLabel();
        farmOA2 = new javax.swing.JFormattedTextField();
        ceilingLabel7 = new javax.swing.JLabel();
        compareResult = new javax.swing.JFormattedTextField();
        ageLabel1 = new javax.swing.JLabel();
        age1 = new javax.swing.JFormattedTextField();
        playerTypeC1 = new javax.swing.JFormattedTextField();
        playerTypeC2 = new javax.swing.JFormattedTextField();
        playerTypeC3 = new javax.swing.JFormattedTextField();
        playerTypeC4 = new javax.swing.JFormattedTextField();
        posiC1 = new javax.swing.JFormattedTextField();
        posiC2 = new javax.swing.JFormattedTextField();
        posiC3 = new javax.swing.JFormattedTextField();
        posiC4 = new javax.swing.JFormattedTextField();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openMenu = new javax.swing.JMenuItem();
        writePlayersFile = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        faq = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("sws3/Bundle"); // NOI18N
        setTitle(bundle.getString("GUI.title_1")); // NOI18N
        setResizable(false);

        playerTab.setName("Player"); // NOI18N

        proListLabel.setPreferredSize(new java.awt.Dimension(1119, 1000));
        proListLabel.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                proListLabelPropertyChange(evt);
            }
        });

        teamSearchField.setText(bundle.getString("GUI.teamSearchField.text")); // NOI18N
        teamSearchField.setToolTipText(bundle.getString("GUI.teamSearchField.toolTipText")); // NOI18N
        teamSearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamSearchFieldActionPerformed(evt);
            }
        });
        teamSearchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                teamSearchFieldKeyPressed(evt);
            }
        });

        teamSearchButton.setText(bundle.getString("GUI.teamSearchButton.text")); // NOI18N
        teamSearchButton.setToolTipText(bundle.getString("GUI.teamSearchButton.toolTipText")); // NOI18N
        teamSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teamSearchButtonActionPerformed(evt);
            }
        });

        teamIcon.setText(bundle.getString("GUI.teamIcon.text")); // NOI18N
        teamIcon.setIconTextGap(2);

        proSalaryLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        proSalaryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        proSalaryLabel.setLabelFor(salaryAmtLabel);
        proSalaryLabel.setText(bundle.getString("GUI.proSalaryLabel.text")); // NOI18N
        proSalaryLabel.setToolTipText(bundle.getString("GUI.proSalaryLabel.toolTipText")); // NOI18N

        farmSalaryLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        farmSalaryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        farmSalaryLabel.setLabelFor(salaryAmtLabel);
        farmSalaryLabel.setText(bundle.getString("GUI.farmSalaryLabel.text")); // NOI18N
        farmSalaryLabel.setToolTipText(bundle.getString("GUI.farmSalaryLabel.toolTipText")); // NOI18N

        farmSalary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        farmSalary.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        farmSalary.setText(bundle.getString("GUI.farmSalary.text")); // NOI18N
        farmSalary.setMaximumSize(new java.awt.Dimension(61, 25));
        farmSalary.setMinimumSize(new java.awt.Dimension(25, 25));

        proSalary.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        proSalary.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        proSalary.setText(bundle.getString("GUI.proSalary.text")); // NOI18N
        proSalary.setMaximumSize(new java.awt.Dimension(61, 25));
        proSalary.setMinimumSize(new java.awt.Dimension(25, 25));

        numPlayersLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        numPlayersLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPlayersLabel.setLabelFor(salaryAmtLabel);
        numPlayersLabel.setText(bundle.getString("GUI.numPlayersLabel.text")); // NOI18N
        numPlayersLabel.setToolTipText(bundle.getString("GUI.numPlayersLabel.toolTipText")); // NOI18N

        numPlayers.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        numPlayers.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numPlayers.setText(bundle.getString("GUI.numPlayers.text")); // NOI18N
        numPlayers.setMaximumSize(new java.awt.Dimension(61, 25));
        numPlayers.setMinimumSize(new java.awt.Dimension(25, 25));
        numPlayers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numPlayersActionPerformed(evt);
            }
        });

        proOFLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        proOFLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        proOFLabel.setLabelFor(salaryAmtLabel);
        proOFLabel.setText(bundle.getString("GUI.proOFLabel.text")); // NOI18N
        proOFLabel.setToolTipText(bundle.getString("GUI.proOFLabel.toolTipText")); // NOI18N

        proDFLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        proDFLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        proDFLabel.setLabelFor(salaryAmtLabel);
        proDFLabel.setText(bundle.getString("GUI.proDFLabel.text")); // NOI18N
        proDFLabel.setToolTipText(bundle.getString("GUI.proDFLabel.toolTipText")); // NOI18N

        proOALabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        proOALabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        proOALabel.setLabelFor(salaryAmtLabel);
        proOALabel.setText(bundle.getString("GUI.proOALabel.text")); // NOI18N
        proOALabel.setToolTipText(bundle.getString("GUI.proOALabel.toolTipText")); // NOI18N

        proOffense.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        proOffense.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        proOffense.setText(bundle.getString("GUI.proOffense.text")); // NOI18N
        proOffense.setMaximumSize(new java.awt.Dimension(61, 25));
        proOffense.setMinimumSize(new java.awt.Dimension(25, 25));
        proOffense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proOffenseActionPerformed(evt);
            }
        });

        proDefense.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        proDefense.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        proDefense.setText(bundle.getString("GUI.proDefense.text")); // NOI18N
        proDefense.setMaximumSize(new java.awt.Dimension(61, 25));
        proDefense.setMinimumSize(new java.awt.Dimension(25, 25));
        proDefense.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proDefenseActionPerformed(evt);
            }
        });

        proOA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        proOA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        proOA.setText(bundle.getString("GUI.proOA.text")); // NOI18N
        proOA.setMaximumSize(new java.awt.Dimension(61, 25));
        proOA.setMinimumSize(new java.awt.Dimension(25, 25));
        proOA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proOAActionPerformed(evt);
            }
        });

        numPlayersLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        numPlayersLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPlayersLabel1.setLabelFor(salaryAmtLabel);
        numPlayersLabel1.setText(bundle.getString("GUI.numPlayersLabel1.text")); // NOI18N
        numPlayersLabel1.setToolTipText(bundle.getString("GUI.numPlayersLabel1.toolTipText")); // NOI18N

        numPlayersLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        numPlayersLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPlayersLabel2.setLabelFor(salaryAmtLabel);
        numPlayersLabel2.setText(bundle.getString("GUI.numPlayersLabel2.text")); // NOI18N
        numPlayersLabel2.setToolTipText(bundle.getString("GUI.numPlayersLabel2.toolTipText")); // NOI18N

        numPlayersLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        numPlayersLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPlayersLabel3.setLabelFor(salaryAmtLabel);
        numPlayersLabel3.setText(bundle.getString("GUI.numPlayersLabel3.text")); // NOI18N
        numPlayersLabel3.setToolTipText(bundle.getString("GUI.numPlayersLabel3.toolTipText")); // NOI18N

        numPlayersPro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        numPlayersPro.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numPlayersPro.setText(bundle.getString("GUI.numPlayersPro.text")); // NOI18N
        numPlayersPro.setMaximumSize(new java.awt.Dimension(61, 25));
        numPlayersPro.setMinimumSize(new java.awt.Dimension(25, 25));
        numPlayersPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numPlayersProActionPerformed(evt);
            }
        });

        numPlayersFarm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        numPlayersFarm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numPlayersFarm.setText(bundle.getString("GUI.numPlayersFarm.text")); // NOI18N
        numPlayersFarm.setMaximumSize(new java.awt.Dimension(61, 25));
        numPlayersFarm.setMinimumSize(new java.awt.Dimension(25, 25));
        numPlayersFarm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numPlayersFarmActionPerformed(evt);
            }
        });

        numPlayersProsp.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        numPlayersProsp.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numPlayersProsp.setText(bundle.getString("GUI.numPlayersProsp.text")); // NOI18N
        numPlayersProsp.setMaximumSize(new java.awt.Dimension(61, 25));
        numPlayersProsp.setMinimumSize(new java.awt.Dimension(25, 25));
        numPlayersProsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numPlayersProspActionPerformed(evt);
            }
        });

        lwList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lwList.setDragEnabled(true);
        lwList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lwListMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(lwList);

        lwListLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        lwListLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lwListLabel.setLabelFor(salaryAmtLabel);
        lwListLabel.setText(bundle.getString("GUI.lwListLabel.text")); // NOI18N
        lwListLabel.setToolTipText(bundle.getString("GUI.lwListLabel.toolTipText")); // NOI18N

        cList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        cList.setDragEnabled(true);
        cList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cListMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(cList);

        cListLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        cListLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cListLabel.setLabelFor(salaryAmtLabel);
        cListLabel.setText(bundle.getString("GUI.cListLabel.text")); // NOI18N
        cListLabel.setToolTipText(bundle.getString("GUI.cListLabel.toolTipText")); // NOI18N

        rwList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        rwList.setDragEnabled(true);
        rwList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rwListMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(rwList);

        rwListLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        rwListLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rwListLabel.setLabelFor(salaryAmtLabel);
        rwListLabel.setText(bundle.getString("GUI.rwListLabel.text")); // NOI18N
        rwListLabel.setToolTipText(bundle.getString("GUI.rwListLabel.toolTipText")); // NOI18N

        dList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        dList.setDragEnabled(true);
        dList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dListMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(dList);

        dListLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        dListLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dListLabel.setLabelFor(salaryAmtLabel);
        dListLabel.setText(bundle.getString("GUI.dListLabel.text")); // NOI18N
        dListLabel.setToolTipText(bundle.getString("GUI.dListLabel.toolTipText")); // NOI18N

        gList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        gList.setDragEnabled(true);
        gList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                gListMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(gList);

        gListLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        gListLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gListLabel.setLabelFor(salaryAmtLabel);
        gListLabel.setText(bundle.getString("GUI.gListLabel.text")); // NOI18N
        gListLabel.setToolTipText(bundle.getString("GUI.gListLabel.toolTipText")); // NOI18N

        linesLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        linesLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linesLabel.setLabelFor(salaryAmtLabel);
        linesLabel.setText(bundle.getString("GUI.linesLabel.text")); // NOI18N
        linesLabel.setToolTipText(bundle.getString("GUI.linesLabel.toolTipText")); // NOI18N

        lwLine1.setText(bundle.getString("GUI.lwLine1.text")); // NOI18N

        lwLine2.setText(bundle.getString("GUI.timeLine2.text")); // NOI18N
        lwLine2.setToolTipText(bundle.getString("GUI.lwLine2.toolTipText")); // NOI18N

        lwLine3.setText(bundle.getString("GUI.lwLine3.text")); // NOI18N
        lwLine3.setToolTipText(bundle.getString("GUI.lwLine3.toolTipText")); // NOI18N

        lwLine4.setText(bundle.getString("GUI.lwLine4.text")); // NOI18N
        lwLine4.setToolTipText(bundle.getString("GUI.lwLine4.toolTipText")); // NOI18N

        cLine1.setText(bundle.getString("GUI.cLine1.text")); // NOI18N

        cLine2.setText(bundle.getString("GUI.timeLine2.text")); // NOI18N
        cLine2.setToolTipText(bundle.getString("GUI.cLine2.toolTipText")); // NOI18N

        cLine3.setText(bundle.getString("GUI.cLine3.text")); // NOI18N
        cLine3.setToolTipText(bundle.getString("GUI.cLine3.toolTipText")); // NOI18N

        cLine4.setText(bundle.getString("GUI.cLine4.text")); // NOI18N
        cLine4.setToolTipText(bundle.getString("GUI.cLine4.toolTipText")); // NOI18N

        rwLine1.setText(bundle.getString("GUI.rwLine1.text")); // NOI18N

        rwLine2.setText(bundle.getString("GUI.timeLine2.text")); // NOI18N
        rwLine2.setToolTipText(bundle.getString("GUI.rwLine2.toolTipText")); // NOI18N

        rwLine3.setText(bundle.getString("GUI.rwLine3.text")); // NOI18N
        rwLine3.setToolTipText(bundle.getString("GUI.rwLine3.toolTipText")); // NOI18N

        rwLine4.setText(bundle.getString("GUI.rwLine4.text")); // NOI18N
        rwLine4.setToolTipText(bundle.getString("GUI.rwLine4.toolTipText")); // NOI18N

        gStarting.setText(bundle.getString("GUI.gStarting.text")); // NOI18N

        gBackup.setText(bundle.getString("GUI.gBackup.text")); // NOI18N

        dpair1L.setText(bundle.getString("GUI.dpair1L.text")); // NOI18N
        dpair1L.setToolTipText(bundle.getString("GUI.dpair1L.toolTipText")); // NOI18N

        dpair1R.setText(bundle.getString("GUI.dpair1R.text")); // NOI18N
        dpair1R.setToolTipText(bundle.getString("GUI.dpair1R.toolTipText")); // NOI18N

        dPair2R.setText(bundle.getString("GUI.dPair2R.text")); // NOI18N
        dPair2R.setToolTipText(bundle.getString("GUI.dPair2R.toolTipText")); // NOI18N

        dpair2L.setText(bundle.getString("GUI.dpair2L.text")); // NOI18N
        dpair2L.setToolTipText(bundle.getString("GUI.dpair2L.toolTipText")); // NOI18N

        dpair3R.setText(bundle.getString("GUI.dpair3R.text")); // NOI18N
        dpair3R.setToolTipText(bundle.getString("GUI.dpair3R.toolTipText")); // NOI18N

        dpair3L.setText(bundle.getString("GUI.dpair3L.text")); // NOI18N
        dpair3L.setToolTipText(bundle.getString("GUI.dpair3L.toolTipText")); // NOI18N

        linesTacticsLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        linesTacticsLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linesTacticsLabel.setLabelFor(salaryAmtLabel);
        linesTacticsLabel.setText(bundle.getString("GUI.linesTacticsLabel.text")); // NOI18N
        linesTacticsLabel.setToolTipText(bundle.getString("GUI.linesTacticsLabel.toolTipText")); // NOI18N

        timeLine1.setText(bundle.getString("GUI.timeLine1.text")); // NOI18N

        timeLine2.setText(bundle.getString("GUI.timeLine2.text")); // NOI18N
        timeLine2.setToolTipText(bundle.getString("GUI.timeLine2.toolTipText")); // NOI18N

        timeLine3.setText(bundle.getString("GUI.timeLine3.text")); // NOI18N
        timeLine3.setToolTipText(bundle.getString("GUI.timeLine3.toolTipText")); // NOI18N

        timeLine4.setText(bundle.getString("GUI.timeLine4.text")); // NOI18N
        timeLine4.setToolTipText(bundle.getString("GUI.timeLine4.toolTipText")); // NOI18N

        buttonGroup1.add(proTeamButton);
        proTeamButton.setSelected(true);
        proTeamButton.setText(bundle.getString("GUI.proTeamButton.text")); // NOI18N
        proTeamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                proTeamButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(farmTeamButton);
        farmTeamButton.setText(bundle.getString("GUI.farmTeamButton.text")); // NOI18N
        farmTeamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                farmTeamButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(prospectsButton);
        prospectsButton.setText(bundle.getString("GUI.prospectsButton.text")); // NOI18N
        prospectsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prospectsButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(allButton);
        allButton.setText(bundle.getString("GUI.allButton.text")); // NOI18N
        allButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allButtonActionPerformed(evt);
            }
        });

        TacticsLine1.setMaximumRowCount(5);
        TacticsLine1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Run & Gun", "Passing Plays", "Dump & Chase", "Hit & Grind", "Neutral Zone Trap" }));

        TacticsPP1.setMaximumRowCount(5);
        TacticsPP1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Shooting", "Screen & Shoot", "Passing Plays", "Crash the Net", "Shot From Point" }));

        timePP2.setText(bundle.getString("GUI.timePP2.text")); // NOI18N

        lwLinePP1.setText(bundle.getString("GUI.lwLinePP1.text")); // NOI18N

        lwLinePP2.setText(bundle.getString("GUI.lwLinePP2.text")); // NOI18N

        cLinePP2.setText(bundle.getString("GUI.cLinePP2.text")); // NOI18N

        cLinePP1.setText(bundle.getString("GUI.cLinePP1.text")); // NOI18N

        rwLinePP2.setText(bundle.getString("GUI.rwLinePP2.text")); // NOI18N

        rwLinePP1.setText(bundle.getString("GUI.rwLinePP1.text")); // NOI18N

        dpairLPP1.setText(bundle.getString("GUI.dpairLPP1.text")); // NOI18N

        dpairRPP1.setText(bundle.getString("GUI.dpairRPP1.text")); // NOI18N

        dPairRPP2.setText(bundle.getString("GUI.dPairRPP2.text")); // NOI18N

        dpairLPP2.setText(bundle.getString("GUI.dpairLPP2.text")); // NOI18N

        timePP1.setText(bundle.getString("GUI.timePP1.text")); // NOI18N

        TacticsPP2.setMaximumRowCount(5);
        TacticsPP2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Shooting", "Screen & Shoot", "Passing Plays", "Crash the Net", "Shot From Point" }));

        rwPK1.setText(bundle.getString("GUI.rwPK1.text")); // NOI18N
        rwPK1.setToolTipText(bundle.getString("GUI.rwPK1.toolTipText")); // NOI18N

        dPairRPK1.setText(bundle.getString("GUI.dPairRPK1.text")); // NOI18N
        dPairRPK1.setToolTipText(bundle.getString("GUI.dPairRPK1.toolTipText")); // NOI18N

        dpairLPK1.setText(bundle.getString("GUI.dpairLPK1.text")); // NOI18N
        dpairLPK1.setToolTipText(bundle.getString("GUI.dpairLPK1.toolTipText")); // NOI18N

        lwPK1.setText(bundle.getString("GUI.lwPK1.text")); // NOI18N
        lwPK1.setToolTipText(bundle.getString("GUI.lwPK1.toolTipText")); // NOI18N

        TacticsLine2.setMaximumRowCount(5);
        TacticsLine2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Run & Gun", "Passing Plays", "Dump & Chase", "Hit & Grind", "Neutral Zone Trap" }));

        TacticsLine3.setMaximumRowCount(5);
        TacticsLine3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Run & Gun", "Passing Plays", "Dump & Chase", "Hit & Grind", "Neutral Zone Trap" }));

        TacticsLine4.setMaximumRowCount(5);
        TacticsLine4.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Run & Gun", "Passing Plays", "Dump & Chase", "Hit & Grind", "Neutral Zone Trap" }));

        linesLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        linesLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linesLabel1.setLabelFor(salaryAmtLabel);
        linesLabel1.setText(bundle.getString("GUI.linesLabel1.text")); // NOI18N
        linesLabel1.setToolTipText(bundle.getString("GUI.linesLabel1.toolTipText")); // NOI18N

        linesLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        linesLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linesLabel2.setLabelFor(salaryAmtLabel);
        linesLabel2.setText(bundle.getString("GUI.linesLabel2.text")); // NOI18N
        linesLabel2.setToolTipText(bundle.getString("GUI.linesLabel2.toolTipText")); // NOI18N

        dPairRPK2.setText(bundle.getString("GUI.dPairRPK2.text")); // NOI18N
        dPairRPK2.setToolTipText(bundle.getString("GUI.dPairRPK2.toolTipText")); // NOI18N

        rwPK2.setText(bundle.getString("GUI.rwPK2.text")); // NOI18N
        rwPK2.setToolTipText(bundle.getString("GUI.rwPK2.toolTipText")); // NOI18N

        lwPK2.setText(bundle.getString("GUI.lwPK2.text")); // NOI18N
        lwPK2.setToolTipText(bundle.getString("GUI.lwPK2.toolTipText")); // NOI18N

        dpairLPK2.setText(bundle.getString("GUI.dpairLPK2.text")); // NOI18N
        dpairLPK2.setToolTipText(bundle.getString("GUI.dpairLPK2.toolTipText")); // NOI18N

        linesLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        linesLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linesLabel3.setLabelFor(salaryAmtLabel);
        linesLabel3.setText(bundle.getString("GUI.linesLabel3.text")); // NOI18N
        linesLabel3.setToolTipText(bundle.getString("GUI.linesLabel3.toolTipText")); // NOI18N

        linesLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        linesLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linesLabel4.setLabelFor(salaryAmtLabel);
        linesLabel4.setText(bundle.getString("GUI.linesLabel4.text")); // NOI18N
        linesLabel4.setToolTipText(bundle.getString("GUI.linesLabel4.toolTipText")); // NOI18N

        TacticsPK1.setMaximumRowCount(5);
        TacticsPK1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aggressive", "Loose Box", "Passive Box", "Small Box", "Tight Box" }));

        timePK1.setText(bundle.getString("GUI.timePK1.text")); // NOI18N
        timePK1.setToolTipText(bundle.getString("GUI.timePK1.toolTipText")); // NOI18N

        TacticsPK2.setMaximumRowCount(5);
        TacticsPK2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aggressive", "Loose Box", "Passive Box", "Small Box", "Tight Box" }));

        timePK2.setText(bundle.getString("GUI.timePK2.text")); // NOI18N
        timePK2.setToolTipText(bundle.getString("GUI.timePK2.toolTipText")); // NOI18N

        linesLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        linesLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linesLabel5.setLabelFor(salaryAmtLabel);
        linesLabel5.setText(bundle.getString("GUI.linesLabel5.text")); // NOI18N
        linesLabel5.setToolTipText(bundle.getString("GUI.linesLabel5.toolTipText")); // NOI18N

        createLinesButton.setText(bundle.getString("GUI.createLinesButton.text")); // NOI18N
        createLinesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createLinesButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout proListLabelLayout = new javax.swing.GroupLayout(proListLabel);
        proListLabel.setLayout(proListLabelLayout);
        proListLabelLayout.setHorizontalGroup(
            proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proListLabelLayout.createSequentialGroup()
                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(proListLabelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(proListLabelLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(lwListLabel)
                                .addGap(141, 141, 141)
                                .addComponent(cListLabel))
                            .addGroup(proListLabelLayout.createSequentialGroup()
                                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(proListLabelLayout.createSequentialGroup()
                                                .addComponent(dListLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(gListLabel))
                                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, proListLabelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(linesLabel1)
                                                .addGap(19, 19, 19))
                                            .addGroup(proListLabelLayout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))))
                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(linesLabel3)
                                            .addComponent(linesLabel2)
                                            .addComponent(linesLabel5, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)))
                                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(dpairLPP2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dPairRPP2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(dpairLPP1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dpairRPP1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addComponent(dpair1L, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dpair1R, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                        .addGap(44, 44, 44)
                                        .addComponent(dpair3L, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dpair3R, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(proListLabelLayout.createSequentialGroup()
                                                .addGap(118, 118, 118)
                                                .addComponent(linesLabel))
                                            .addGroup(proListLabelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lwLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rwLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(10, 10, 10)
                                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(proListLabelLayout.createSequentialGroup()
                                                .addComponent(timeLine1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(TacticsLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(linesTacticsLabel)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, proListLabelLayout.createSequentialGroup()
                                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, proListLabelLayout.createSequentialGroup()
                                                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                                        .addComponent(lwLine3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(cLine3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(rwLine3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                                        .addComponent(lwLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(cLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(rwLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                                        .addComponent(timeLine3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(TacticsLine3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                                        .addComponent(timeLine2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(TacticsLine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, proListLabelLayout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addComponent(dpair2L, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dPair2R, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, proListLabelLayout.createSequentialGroup()
                                                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                                        .addComponent(dpairLPK1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(dPairRPK1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                                        .addComponent(lwPK1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(rwPK1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                                        .addComponent(timePK1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(TacticsPK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, proListLabelLayout.createSequentialGroup()
                                                        .addComponent(gStarting, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(gBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(linesLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(createLinesButton)
                                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                                        .addComponent(timePK2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(TacticsPK2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(proListLabelLayout.createSequentialGroup()
                                                            .addComponent(dpairLPK2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(dPairRPK2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, proListLabelLayout.createSequentialGroup()
                                                            .addComponent(lwPK2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(rwPK2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, proListLabelLayout.createSequentialGroup()
                                                    .addComponent(lwLinePP2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cLinePP2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(rwLinePP2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(timePP2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(TacticsPP2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, proListLabelLayout.createSequentialGroup()
                                                    .addComponent(lwLinePP1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cLinePP1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(rwLinePP1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(10, 10, 10)
                                                    .addComponent(timePP1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(TacticsPP1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, proListLabelLayout.createSequentialGroup()
                                                    .addComponent(lwLine4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(cLine4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(rwLine4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(timeLine4, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(TacticsLine4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(278, 278, 278))))))
                    .addGroup(proListLabelLayout.createSequentialGroup()
                        .addComponent(teamIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(proListLabelLayout.createSequentialGroup()
                                .addComponent(proTeamButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(farmTeamButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(prospectsButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(allButton))
                            .addGroup(proListLabelLayout.createSequentialGroup()
                                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                        .addComponent(proSalaryLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(farmSalaryLabel))
                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                        .addComponent(proSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(farmSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(numPlayersLabel))
                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                        .addGap(90, 90, 90)
                                        .addComponent(numPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(numPlayersPro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(numPlayersLabel1)
                                            .addComponent(rwListLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(numPlayersFarm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(numPlayersLabel2))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(numPlayersLabel3)
                                            .addGroup(proListLabelLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(numPlayersProsp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(85, 85, 85)
                                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(proListLabelLayout.createSequentialGroup()
                                                .addComponent(proOFLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(proDFLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(proOALabel))
                                            .addGroup(proListLabelLayout.createSequentialGroup()
                                                .addComponent(proOffense, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(proDefense, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(proOA, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(proListLabelLayout.createSequentialGroup()
                                        .addComponent(teamSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(teamSearchButton))))))
                    .addGroup(proListLabelLayout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        proListLabelLayout.setVerticalGroup(
            proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proListLabelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(teamIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(proListLabelLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(teamSearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(teamSearchButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(proSalaryLabel)
                            .addComponent(farmSalaryLabel)
                            .addComponent(numPlayersLabel)
                            .addComponent(numPlayersLabel1)
                            .addComponent(numPlayersLabel2)
                            .addComponent(numPlayersLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(farmSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(proSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numPlayers, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numPlayersPro, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numPlayersFarm, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numPlayersProsp, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(proListLabelLayout.createSequentialGroup()
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(proOFLabel)
                            .addComponent(proDFLabel)
                            .addComponent(proOALabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(proOffense, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(proDefense, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(proOA, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(proListLabelLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(proTeamButton)
                            .addComponent(farmTeamButton)
                            .addComponent(prospectsButton)
                            .addComponent(allButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lwListLabel)
                            .addComponent(cListLabel)
                            .addComponent(rwListLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dListLabel)
                            .addComponent(gListLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)))
                    .addGroup(proListLabelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(linesLabel)
                            .addComponent(linesTacticsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rwLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TacticsLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lwLine1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dpair1L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dpair1R, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(proListLabelLayout.createSequentialGroup()
                                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lwLine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cLine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rwLine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dpair2L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dPair2R, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lwLine3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cLine3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rwLine3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dpair3L, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dpair3R, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(proListLabelLayout.createSequentialGroup()
                                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(timeLine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TacticsLine2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(timeLine3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TacticsLine3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lwLine4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cLine4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rwLine4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeLine4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TacticsLine4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lwLinePP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(linesLabel1))
                            .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cLinePP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(rwLinePP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(timePP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TacticsPP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dpairLPP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dpairRPP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lwLinePP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cLinePP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rwLinePP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timePP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TacticsPP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(linesLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dpairLPP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dPairRPP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linesLabel4)
                            .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(proListLabelLayout.createSequentialGroup()
                                    .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lwPK2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rwPK2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dpairLPK2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dPairRPK2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(proListLabelLayout.createSequentialGroup()
                                    .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(linesLabel3)
                                        .addComponent(lwPK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rwPK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(dpairLPK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dPairRPK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timePK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TacticsPK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timePK2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(TacticsPK2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(proListLabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(gStarting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gBackup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(linesLabel5)
                    .addComponent(createLinesButton))
                .addGap(1267, 1267, 1267))
        );

        playerTab.addTab(bundle.getString("GUI.proListLabel.TabConstraints.tabTitle"), proListLabel); // NOI18N

        draftYearList.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017" }));
        draftYearList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                draftYearListMouseClicked(evt);
            }
        });
        draftYearList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                draftYearListActionPerformed(evt);
            }
        });

        cListLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        cListLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cListLabel1.setLabelFor(salaryAmtLabel);
        cListLabel1.setText(bundle.getString("GUI.cListLabel1.text")); // NOI18N
        cListLabel1.setToolTipText(bundle.getString("GUI.cListLabel1.toolTipText")); // NOI18N

        draftCList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        draftCList.setDragEnabled(true);
        draftCList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                draftCListMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(draftCList);

        lwListLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        lwListLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lwListLabel1.setLabelFor(salaryAmtLabel);
        lwListLabel1.setText(bundle.getString("GUI.lwListLabel1.text")); // NOI18N
        lwListLabel1.setToolTipText(bundle.getString("GUI.lwListLabel1.toolTipText")); // NOI18N

        dListLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        dListLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dListLabel1.setLabelFor(salaryAmtLabel);
        dListLabel1.setText(bundle.getString("GUI.dListLabel1.text")); // NOI18N
        dListLabel1.setToolTipText(bundle.getString("GUI.dListLabel1.toolTipText")); // NOI18N

        draftDList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        draftDList.setDragEnabled(true);
        draftDList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                draftDListMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(draftDList);

        rwListLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        rwListLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rwListLabel1.setLabelFor(salaryAmtLabel);
        rwListLabel1.setText(bundle.getString("GUI.rwListLabel1.text")); // NOI18N
        rwListLabel1.setToolTipText(bundle.getString("GUI.rwListLabel1.toolTipText")); // NOI18N

        draftRwList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        draftRwList.setDragEnabled(true);
        draftRwList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                draftRwListMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(draftRwList);

        gListLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        gListLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gListLabel1.setLabelFor(salaryAmtLabel);
        gListLabel1.setText(bundle.getString("GUI.gListLabel1.text")); // NOI18N
        gListLabel1.setToolTipText(bundle.getString("GUI.gListLabel1.toolTipText")); // NOI18N

        draftGList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        draftGList.setDragEnabled(true);
        draftGList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                draftGListMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(draftGList);

        draftLwList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        draftLwList.setDragEnabled(true);
        draftLwList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                draftLwListMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(draftLwList);

        draftOFLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        draftOFLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        draftOFLabel.setLabelFor(salaryAmtLabel);
        draftOFLabel.setText(bundle.getString("GUI.draftOFLabel.text")); // NOI18N
        draftOFLabel.setToolTipText(bundle.getString("GUI.draftOFLabel.toolTipText")); // NOI18N

        draftOALabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        draftOALabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        draftOALabel.setLabelFor(salaryAmtLabel);
        draftOALabel.setText(bundle.getString("GUI.draftOALabel.text")); // NOI18N
        draftOALabel.setToolTipText(bundle.getString("GUI.draftOALabel.toolTipText")); // NOI18N

        draftDLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        draftDLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        draftDLabel.setLabelFor(salaryAmtLabel);
        draftDLabel.setText(bundle.getString("GUI.draftDLabel.text")); // NOI18N
        draftDLabel.setToolTipText(bundle.getString("GUI.draftDLabel.toolTipText")); // NOI18N

        draftDLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        draftDLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        draftDLabel1.setLabelFor(salaryAmtLabel);
        draftDLabel1.setText(bundle.getString("GUI.draftDLabel1.text")); // NOI18N
        draftDLabel1.setToolTipText(bundle.getString("GUI.draftDLabel1.toolTipText")); // NOI18N

        draftOALabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        draftOALabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        draftOALabel1.setLabelFor(salaryAmtLabel);
        draftOALabel1.setText(bundle.getString("GUI.draftOALabel1.text")); // NOI18N
        draftOALabel1.setToolTipText(bundle.getString("GUI.draftOALabel1.toolTipText")); // NOI18N

        draftOFLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        draftOFLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        draftOFLabel1.setLabelFor(salaryAmtLabel);
        draftOFLabel1.setText(bundle.getString("GUI.draftOFLabel1.text")); // NOI18N
        draftOFLabel1.setToolTipText(bundle.getString("GUI.draftOFLabel1.toolTipText")); // NOI18N

        draftOALabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        draftOALabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        draftOALabel2.setLabelFor(salaryAmtLabel);
        draftOALabel2.setText(bundle.getString("GUI.draftOALabel2.text")); // NOI18N
        draftOALabel2.setToolTipText(bundle.getString("GUI.draftOALabel2.toolTipText")); // NOI18N

        draftDLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        draftDLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        draftDLabel2.setLabelFor(salaryAmtLabel);
        draftDLabel2.setText(bundle.getString("GUI.draftDLabel2.text")); // NOI18N
        draftDLabel2.setToolTipText(bundle.getString("GUI.draftDLabel2.toolTipText")); // NOI18N

        draftOFLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        draftOFLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        draftOFLabel2.setLabelFor(salaryAmtLabel);
        draftOFLabel2.setText(bundle.getString("GUI.draftOFLabel2.text")); // NOI18N
        draftOFLabel2.setToolTipText(bundle.getString("GUI.draftOFLabel2.toolTipText")); // NOI18N

        numPlayersDraft.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        numPlayersDraft.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        numPlayersDraft.setText(bundle.getString("GUI.numPlayersDraft.text")); // NOI18N
        numPlayersDraft.setMaximumSize(new java.awt.Dimension(61, 25));
        numPlayersDraft.setMinimumSize(new java.awt.Dimension(25, 25));

        numPlayersLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        numPlayersLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numPlayersLabel4.setLabelFor(salaryAmtLabel);
        numPlayersLabel4.setText(bundle.getString("GUI.numPlayersLabel4.text")); // NOI18N
        numPlayersLabel4.setToolTipText(bundle.getString("GUI.numPlayersLabel4.toolTipText")); // NOI18N

        draftOF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftOF.setText(bundle.getString("GUI.draftOF.text")); // NOI18N

        draftDF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftDF.setText(bundle.getString("GUI.draftDF.text")); // NOI18N

        draftOA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftOA.setText(bundle.getString("GUI.draftOA.text")); // NOI18N

        draftPOF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPOF.setText(bundle.getString("GUI.draftPOF.text")); // NOI18N

        draftPDF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPDF.setText(bundle.getString("GUI.draftPDF.text")); // NOI18N

        draftPOA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPOA.setText(bundle.getString("GUI.draftPOA.text")); // NOI18N

        draftTOF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTOF.setText(bundle.getString("GUI.draftTOF.text")); // NOI18N

        draftTDF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTDF.setText(bundle.getString("GUI.draftTDF.text")); // NOI18N

        draftTOA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTOA.setText(bundle.getString("GUI.draftTOA.text")); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel3.setText(bundle.getString("GUI.jLabel3.text")); // NOI18N

        draftOA1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftOA1.setText(bundle.getString("GUI.draftOA1.text")); // NOI18N

        draftPOF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPOF1.setText(bundle.getString("GUI.draftPOF1.text")); // NOI18N

        draftOF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftOF1.setText(bundle.getString("GUI.draftOF1.text")); // NOI18N

        draftDF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftDF1.setText(bundle.getString("GUI.draftDF1.text")); // NOI18N

        draftTOA1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTOA1.setText(bundle.getString("GUI.draftTOA1.text")); // NOI18N

        draftTOF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTOF1.setText(bundle.getString("GUI.draftTOF1.text")); // NOI18N

        draftTDF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTDF1.setText(bundle.getString("GUI.draftTDF1.text")); // NOI18N

        draftPDF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPDF1.setText(bundle.getString("GUI.draftPDF1.text")); // NOI18N

        draftPOA1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPOA1.setText(bundle.getString("GUI.draftPOA1.text")); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel4.setText(bundle.getString("GUI.jLabel4.text")); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel5.setText(bundle.getString("GUI.jLabel5.text")); // NOI18N

        draftOF2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftOF2.setText(bundle.getString("GUI.draftOF2.text")); // NOI18N

        draftTOA2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTOA2.setText(bundle.getString("GUI.draftTOA2.text")); // NOI18N

        draftDF2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftDF2.setText(bundle.getString("GUI.draftDF2.text")); // NOI18N

        draftTDF2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTDF2.setText(bundle.getString("GUI.draftTDF2.text")); // NOI18N

        draftTOF2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTOF2.setText(bundle.getString("GUI.draftTOF2.text")); // NOI18N

        draftPOA2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPOA2.setText(bundle.getString("GUI.draftPOA2.text")); // NOI18N

        draftPDF2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPDF2.setText(bundle.getString("GUI.draftPDF2.text")); // NOI18N

        draftPOF2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPOF2.setText(bundle.getString("GUI.draftPOF2.text")); // NOI18N

        draftOA2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftOA2.setText(bundle.getString("GUI.draftOA2.text")); // NOI18N

        draftPOF3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPOF3.setText(bundle.getString("GUI.draftPOF3.text")); // NOI18N

        draftOA3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftOA3.setText(bundle.getString("GUI.draftOA3.text")); // NOI18N

        draftPOA3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPOA3.setText(bundle.getString("GUI.draftPOA3.text")); // NOI18N

        draftPDF3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPDF3.setText(bundle.getString("GUI.draftPDF3.text")); // NOI18N

        draftTDF3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTDF3.setText(bundle.getString("GUI.draftTDF3.text")); // NOI18N

        draftTOF3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTOF3.setText(bundle.getString("GUI.draftTOF3.text")); // NOI18N

        draftTOA3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTOA3.setText(bundle.getString("GUI.draftTOA3.text")); // NOI18N

        draftDF3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftDF3.setText(bundle.getString("GUI.draftDF3.text")); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel6.setText(bundle.getString("GUI.jLabel6.text")); // NOI18N

        draftOF3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftOF3.setText(bundle.getString("GUI.draftOF3.text")); // NOI18N

        draftPOF4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPOF4.setText(bundle.getString("GUI.draftPOF4.text")); // NOI18N

        draftOA4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftOA4.setText(bundle.getString("GUI.draftOA4.text")); // NOI18N

        draftPOA4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPOA4.setText(bundle.getString("GUI.draftPOA4.text")); // NOI18N

        draftPDF4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPDF4.setText(bundle.getString("GUI.draftPDF4.text")); // NOI18N

        draftTDF4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTDF4.setText(bundle.getString("GUI.draftTDF4.text")); // NOI18N

        draftTOF4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTOF4.setText(bundle.getString("GUI.draftTOF4.text")); // NOI18N

        draftTOA4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTOA4.setText(bundle.getString("GUI.draftTOA4.text")); // NOI18N

        draftDF4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftDF4.setText(bundle.getString("GUI.draftDF4.text")); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel7.setText(bundle.getString("GUI.jLabel7.text")); // NOI18N

        draftOF4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftOF4.setText(bundle.getString("GUI.draftOF4.text")); // NOI18N

        draftPOF5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPOF5.setText(bundle.getString("GUI.draftPOF5.text")); // NOI18N

        draftOA5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftOA5.setText(bundle.getString("GUI.draftOA5.text")); // NOI18N

        draftPOA5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPOA5.setText(bundle.getString("GUI.draftPOA5.text")); // NOI18N

        draftPDF5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPDF5.setText(bundle.getString("GUI.draftPDF5.text")); // NOI18N

        draftTDF5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTDF5.setText(bundle.getString("GUI.draftTDF5.text")); // NOI18N

        draftTOF5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTOF5.setText(bundle.getString("GUI.draftTOF5.text")); // NOI18N

        draftTOA5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTOA5.setText(bundle.getString("GUI.draftTOA5.text")); // NOI18N

        draftDF5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftDF5.setText(bundle.getString("GUI.draftDF5.text")); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel8.setText(bundle.getString("GUI.jLabel8.text")); // NOI18N

        draftOF5.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftOF5.setText(bundle.getString("GUI.draftOF5.text")); // NOI18N

        draftBestAvailable.setDragEnabled(true);
        draftBestAvailable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                draftBestAvailableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(draftBestAvailable);

        myDraftList.setDragEnabled(true);
        myDraftList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                myDraftListMouseClicked(evt);
            }
        });
        myDraftList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                myDraftListKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(myDraftList);

        bestAvailableLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        bestAvailableLabel.setText(bundle.getString("GUI.bestAvailableLabel.text")); // NOI18N

        draftQueue.setFont(new java.awt.Font("Tahoma", 1, 11));
        draftQueue.setText(bundle.getString("GUI.draftQueue.text")); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel9.setText(bundle.getString("GUI.jLabel9.text")); // NOI18N

        queueButton.setText(bundle.getString("GUI.queueButton.text")); // NOI18N
        queueButton.setToolTipText(bundle.getString("GUI.queueButton.toolTipText")); // NOI18N
        queueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queueButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout draftTabLayout = new javax.swing.GroupLayout(draftTab);
        draftTab.setLayout(draftTabLayout);
        draftTabLayout.setHorizontalGroup(
            draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(draftTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(draftTabLayout.createSequentialGroup()
                        .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(draftTabLayout.createSequentialGroup()
                                .addComponent(draftYearList, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(draftTabLayout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(lwListLabel1)
                                        .addGap(158, 158, 158)
                                        .addComponent(cListLabel1)
                                        .addGap(152, 152, 152)
                                        .addComponent(rwListLabel1)
                                        .addGap(154, 154, 154)
                                        .addComponent(dListLabel1)
                                        .addGap(157, 157, 157)
                                        .addComponent(gListLabel1))
                                    .addGroup(draftTabLayout.createSequentialGroup()
                                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(draftTabLayout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(bestAvailableLabel)
                                                .addGap(97, 97, 97)
                                                .addComponent(draftQueue))
                                            .addGroup(draftTabLayout.createSequentialGroup()
                                                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(draftTabLayout.createSequentialGroup()
                                .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(draftTabLayout.createSequentialGroup()
                                        .addGap(74, 74, 74)
                                        .addComponent(draftOFLabel)
                                        .addGap(35, 35, 35)
                                        .addComponent(draftDLabel)
                                        .addGap(38, 38, 38)
                                        .addComponent(draftOALabel)
                                        .addGap(32, 32, 32)
                                        .addComponent(draftOFLabel1)
                                        .addGap(28, 28, 28)
                                        .addComponent(draftDLabel1)
                                        .addGap(30, 30, 30)
                                        .addComponent(draftOALabel1)
                                        .addGap(27, 27, 27)
                                        .addComponent(draftOFLabel2)
                                        .addGap(31, 31, 31)
                                        .addComponent(draftDLabel2)
                                        .addGap(28, 28, 28)
                                        .addComponent(draftOALabel2))
                                    .addGroup(draftTabLayout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(draftOF2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftDF2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftOA2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftPOF2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftPDF2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftPOA2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftTOF2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftTDF2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftTOA2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(draftTabLayout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addGap(18, 18, 18)
                                            .addComponent(draftOF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(draftDF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(draftOA, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(draftPOF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(draftPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(draftPOA, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(draftTOF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(draftTDF, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(draftTOA, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(draftTabLayout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(draftOF1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(draftDF1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(draftOA1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(draftPOF1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(draftPDF1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(draftPOA1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(draftTOF1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(draftTDF1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(draftTOA1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(draftTabLayout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(draftOF3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftDF3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftOA3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftPOF3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftPDF3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftPOA3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftTOF3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftTDF3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftTOA3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(draftTabLayout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(draftOF4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftDF4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftOA4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftPOF4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftPDF4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftPOA4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftTOF4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftTDF4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftTOA4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(draftTabLayout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(draftOF5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftDF5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftOA5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftPOF5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftPDF5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftPOA5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftTOF5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftTDF5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(draftTOA5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(draftTabLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(numPlayersDraft, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE))
                            .addComponent(queueButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap(74, Short.MAX_VALUE))
                    .addGroup(draftTabLayout.createSequentialGroup()
                        .addComponent(numPlayersLabel4)
                        .addGap(576, 576, 576)
                        .addComponent(jLabel9)
                        .addContainerGap())))
        );
        draftTabLayout.setVerticalGroup(
            draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, draftTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dListLabel1)
                    .addComponent(gListLabel1)
                    .addComponent(cListLabel1)
                    .addComponent(lwListLabel1)
                    .addComponent(rwListLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                    .addComponent(jScrollPane10)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(draftYearList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bestAvailableLabel)
                    .addComponent(draftQueue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numPlayersLabel4)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(draftTabLayout.createSequentialGroup()
                        .addComponent(numPlayersDraft, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(draftOFLabel)
                            .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(draftOALabel2)
                                .addComponent(draftDLabel2)
                                .addComponent(draftOFLabel2)
                                .addComponent(draftOALabel1)
                                .addComponent(draftDLabel1)
                                .addComponent(draftOFLabel1)
                                .addComponent(draftOALabel)
                                .addComponent(draftDLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(draftOF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftOA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPOF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPOA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTOF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTOA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(draftOF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftDF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftOA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPOF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPDF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPOA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTOF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTDF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTOA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(draftDF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftOA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPOF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPDF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPOA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTOF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTDF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTOA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(draftOF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(draftDF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftOA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPOF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPDF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPOA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTOF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTDF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTOA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(draftOF3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(draftDF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftOA4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPOF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPDF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPOA4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTOF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTDF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTOA4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(draftOF4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(draftTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(draftDF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftOA5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPOF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPDF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftPOA5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTOF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTDF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(draftTOA5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(draftOF5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(queueButton)
                .addGap(1302, 1302, 1302))
        );

        playerTab.addTab(bundle.getString("GUI.draftTab.TabConstraints.tabTitle"), draftTab); // NOI18N

        playerPanel.setMaximumSize(new java.awt.Dimension(15000, 15000));
        playerPanel.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                playerPanelAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        playerIcon.setText(bundle.getString("GUI.playerIcon.text")); // NOI18N
        playerIcon.setIconTextGap(2);

        searchField.setText(bundle.getString("GUI.searchField.text")); // NOI18N
        searchField.setToolTipText(bundle.getString("GUI.searchField.toolTipText")); // NOI18N
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchFieldKeyPressed(evt);
            }
        });

        searchPlayer.setText(bundle.getString("GUI.searchPlayer.text")); // NOI18N
        searchPlayer.setToolTipText(bundle.getString("GUI.searchPlayer.toolTipText")); // NOI18N
        searchPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchPlayerActionPerformed(evt);
            }
        });

        mainPOSI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mainPOSI.setText(bundle.getString("GUI.mainPOSI.text")); // NOI18N
        mainPOSI.setToolTipText(bundle.getString("GUI.mainPOSI.toolTipText")); // NOI18N
        mainPOSI.setFont(new java.awt.Font("Tahoma", 1, 11));
        mainPOSI.setMaximumSize(new java.awt.Dimension(15, 25));
        mainPOSI.setMinimumSize(new java.awt.Dimension(15, 25));
        mainPOSI.setPreferredSize(new java.awt.Dimension(15, 25));
        mainPOSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainPOSIActionPerformed(evt);
            }
        });

        altPOSI.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        altPOSI.setText(bundle.getString("GUI.altPOSI.text")); // NOI18N
        altPOSI.setToolTipText(bundle.getString("GUI.altPOSI.toolTipText")); // NOI18N
        altPOSI.setFont(new java.awt.Font("Tahoma", 1, 11));
        altPOSI.setMaximumSize(new java.awt.Dimension(15, 25));
        altPOSI.setMinimumSize(new java.awt.Dimension(15, 25));
        altPOSI.setPreferredSize(new java.awt.Dimension(15, 25));
        altPOSI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altPOSIActionPerformed(evt);
            }
        });

        rightsField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        rightsField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        rightsField.setText(bundle.getString("GUI.rightsField.text")); // NOI18N
        rightsField.setToolTipText(bundle.getString("GUI.rightsField.toolTipText")); // NOI18N
        rightsField.setPreferredSize(new java.awt.Dimension(30, 20));
        rightsField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightsFieldActionPerformed(evt);
            }
        });

        rightsLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        rightsLabel.setLabelFor(rightsField);
        rightsLabel.setText(bundle.getString("GUI.rightsLabel.text")); // NOI18N
        rightsLabel.setToolTipText(bundle.getString("GUI.rightsLabel.toolTipText")); // NOI18N
        rightsLabel.setPreferredSize(new java.awt.Dimension(30, 25));

        draftLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        draftLabel.setText(bundle.getString("GUI.draftLabel.text")); // NOI18N
        draftLabel.setToolTipText(bundle.getString("GUI.draftLabel.toolTipText")); // NOI18N

        draftYr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        draftYr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftYr.setText(bundle.getString("GUI.draftYr.text")); // NOI18N
        draftYr.setToolTipText(bundle.getString("GUI.draftYr.toolTipText")); // NOI18N
        draftYr.setMaximumSize(new java.awt.Dimension(25, 25));
        draftYr.setMinimumSize(new java.awt.Dimension(25, 25));
        draftYr.setPreferredSize(new java.awt.Dimension(25, 25));
        draftYr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                draftYrActionPerformed(evt);
            }
        });

        draftRd.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        draftRd.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftRd.setText(bundle.getString("GUI.draftRd.text")); // NOI18N
        draftRd.setToolTipText(bundle.getString("GUI.draftRd.toolTipText")); // NOI18N
        draftRd.setMaximumSize(new java.awt.Dimension(25, 25));
        draftRd.setMinimumSize(new java.awt.Dimension(25, 25));
        draftRd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                draftRdActionPerformed(evt);
            }
        });

        draftPos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        draftPos.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftPos.setText(bundle.getString("GUI.draftPos.text")); // NOI18N
        draftPos.setToolTipText(bundle.getString("GUI.draftPos.toolTipText")); // NOI18N
        draftPos.setMaximumSize(new java.awt.Dimension(25, 25));
        draftPos.setMinimumSize(new java.awt.Dimension(25, 25));
        draftPos.setPreferredSize(new java.awt.Dimension(25, 25));
        draftPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                draftPosActionPerformed(evt);
            }
        });

        draftTeam.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        draftTeam.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        draftTeam.setText(bundle.getString("GUI.draftTeam.text")); // NOI18N
        draftTeam.setToolTipText(bundle.getString("GUI.draftTeam.toolTipText")); // NOI18N
        draftTeam.setMaximumSize(new java.awt.Dimension(25, 25));
        draftTeam.setMinimumSize(new java.awt.Dimension(25, 25));
        draftTeam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                draftTeamActionPerformed(evt);
            }
        });

        draftTeamLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        draftTeamLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        draftTeamLabel.setLabelFor(draftTeam);
        draftTeamLabel.setText(bundle.getString("GUI.draftTeamLabel.text")); // NOI18N
        draftTeamLabel.setToolTipText(bundle.getString("GUI.draftTeamLabel.toolTipText")); // NOI18N

        draftHeaderLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        draftHeaderLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        draftHeaderLabel.setText(bundle.getString("GUI.draftHeaderLabel.text")); // NOI18N

        salaryYr.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        salaryYr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salaryYr.setText(bundle.getString("GUI.salaryYr.text")); // NOI18N
        salaryYr.setToolTipText(bundle.getString("GUI.salaryYr.toolTipText")); // NOI18N
        salaryYr.setMaximumSize(new java.awt.Dimension(25, 25));
        salaryYr.setMinimumSize(new java.awt.Dimension(25, 25));
        salaryYr.setPreferredSize(new java.awt.Dimension(25, 25));
        salaryYr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryYrActionPerformed(evt);
            }
        });

        salaryAmt.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        salaryAmt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salaryAmt.setText(bundle.getString("GUI.salaryAmt.text")); // NOI18N
        salaryAmt.setMaximumSize(new java.awt.Dimension(61, 25));
        salaryAmt.setMinimumSize(new java.awt.Dimension(25, 25));
        salaryAmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryAmtActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setLabelFor(salaryAmtLabel);
        jLabel1.setText(bundle.getString("GUI.jLabel1.text")); // NOI18N
        jLabel1.setToolTipText(bundle.getString("GUI.jLabel1.toolTipText")); // NOI18N

        salaryAmtLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        salaryAmtLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salaryAmtLabel.setLabelFor(salaryAmt);
        salaryAmtLabel.setText(bundle.getString("GUI.salaryAmtLabel.text")); // NOI18N
        salaryAmtLabel.setToolTipText(bundle.getString("GUI.salaryAmtLabel.toolTipText")); // NOI18N

        salaryYrLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        salaryYrLabel.setText(bundle.getString("GUI.salaryYrLabel.text")); // NOI18N
        salaryYrLabel.setToolTipText(bundle.getString("GUI.salaryYrLabel.toolTipText")); // NOI18N
        salaryYrLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        heightLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        heightLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heightLabel.setLabelFor(height);
        heightLabel.setText(bundle.getString("GUI.heightLabel.text")); // NOI18N
        heightLabel.setToolTipText(bundle.getString("GUI.heightLabel.toolTipText")); // NOI18N

        height.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        height.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        height.setText(bundle.getString("GUI.height.text")); // NOI18N
        height.setToolTipText(bundle.getString("GUI.height.toolTipText")); // NOI18N
        height.setMaximumSize(new java.awt.Dimension(25, 25));
        height.setMinimumSize(new java.awt.Dimension(25, 25));
        height.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                heightActionPerformed(evt);
            }
        });

        weightLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        weightLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weightLabel.setLabelFor(weight);
        weightLabel.setText(bundle.getString("GUI.weightLabel.text")); // NOI18N
        weightLabel.setToolTipText(bundle.getString("GUI.weightLabel.toolTipText")); // NOI18N

        weight.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        weight.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        weight.setText(bundle.getString("GUI.weight.text")); // NOI18N
        weight.setToolTipText(bundle.getString("GUI.weight.toolTipText")); // NOI18N
        weight.setMaximumSize(new java.awt.Dimension(40, 25));
        weight.setMinimumSize(new java.awt.Dimension(40, 25));
        weight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weightActionPerformed(evt);
            }
        });

        ageLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        ageLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ageLabel.setLabelFor(age);
        ageLabel.setText(bundle.getString("GUI.ageLabel.text")); // NOI18N
        ageLabel.setToolTipText(bundle.getString("GUI.ageLabel.toolTipText")); // NOI18N

        age.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        age.setEditable(false);
        age.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        age.setText(bundle.getString("GUI.age.text")); // NOI18N
        age.setToolTipText(bundle.getString("GUI.age.toolTipText")); // NOI18N
        age.setMaximumSize(new java.awt.Dimension(35, 25));
        age.setMinimumSize(new java.awt.Dimension(35, 25));

        twoWay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        twoWay.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        twoWay.setText(bundle.getString("GUI.twoWay.text")); // NOI18N
        twoWay.setToolTipText(bundle.getString("GUI.twoWay.toolTipText")); // NOI18N
        twoWay.setMaximumSize(new java.awt.Dimension(25, 25));
        twoWay.setMinimumSize(new java.awt.Dimension(25, 25));
        twoWay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                twoWayActionPerformed(evt);
            }
        });

        twoWayLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        twoWayLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        twoWayLabel.setLabelFor(twoWay);
        twoWayLabel.setText(bundle.getString("GUI.twoWayLabel.text")); // NOI18N
        twoWayLabel.setToolTipText(bundle.getString("GUI.twoWayLabel.toolTipText")); // NOI18N

        countryLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        countryLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        countryLabel.setLabelFor(country);
        countryLabel.setText(bundle.getString("GUI.countryLabel.text")); // NOI18N
        countryLabel.setToolTipText(bundle.getString("GUI.countryLabel.toolTipText")); // NOI18N

        country.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        country.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        country.setText(bundle.getString("GUI.country.text")); // NOI18N
        country.setToolTipText(bundle.getString("GUI.country.toolTipText")); // NOI18N
        country.setMaximumSize(new java.awt.Dimension(125, 25));
        country.setMinimumSize(new java.awt.Dimension(125, 25));
        country.setPreferredSize(new java.awt.Dimension(125, 25));

        hand.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        hand.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        hand.setText(bundle.getString("GUI.hand.text")); // NOI18N
        hand.setToolTipText(bundle.getString("GUI.hand.toolTipText")); // NOI18N
        hand.setMaximumSize(new java.awt.Dimension(25, 25));
        hand.setMinimumSize(new java.awt.Dimension(25, 25));
        hand.setPreferredSize(new java.awt.Dimension(7, 25));
        hand.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                handActionPerformed(evt);
            }
        });

        handLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        handLabel.setLabelFor(hand);
        handLabel.setText(bundle.getString("GUI.handLabel.text")); // NOI18N
        handLabel.setMaximumSize(new java.awt.Dimension(29, 25));
        handLabel.setMinimumSize(new java.awt.Dimension(29, 25));

        clickLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        clickLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clickLabel.setLabelFor(click);
        clickLabel.setText(bundle.getString("GUI.clickLabel.text")); // NOI18N
        clickLabel.setToolTipText(bundle.getString("GUI.clickLabel.toolTipText")); // NOI18N

        click.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        click.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        click.setText(bundle.getString("GUI.click.text")); // NOI18N
        click.setToolTipText(bundle.getString("GUI.click.toolTipText")); // NOI18N
        click.setMaximumSize(new java.awt.Dimension(25, 25));
        click.setMinimumSize(new java.awt.Dimension(25, 25));
        click.setPreferredSize(new java.awt.Dimension(25, 25));
        click.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clickActionPerformed(evt);
            }
        });

        shoLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        shoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        shoLabel.setText(bundle.getString("GUI.shoLabel.text")); // NOI18N
        shoLabel.setToolTipText(bundle.getString("GUI.shoLabel.toolTipText")); // NOI18N
        shoLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        shoLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        plaLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        plaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        plaLabel.setText(bundle.getString("GUI.plaLabel.text")); // NOI18N
        plaLabel.setToolTipText(bundle.getString("GUI.plaLabel.toolTipText")); // NOI18N
        plaLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        plaLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        plaLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        stkLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        stkLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stkLabel.setText(bundle.getString("GUI.stkLabel.text")); // NOI18N
        stkLabel.setToolTipText(bundle.getString("GUI.stkLabel.toolTipText")); // NOI18N
        stkLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        stkLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        stkLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        chkLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        chkLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chkLabel.setText(bundle.getString("GUI.chkLabel.text")); // NOI18N
        chkLabel.setToolTipText(bundle.getString("GUI.chkLabel.toolTipText")); // NOI18N
        chkLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        chkLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        chkLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        posLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        posLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLabel.setText(bundle.getString("GUI.posLabel.text")); // NOI18N
        posLabel.setToolTipText(bundle.getString("GUI.posLabel.toolTipText")); // NOI18N
        posLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        posLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        posLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        hitLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        hitLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hitLabel.setText(bundle.getString("GUI.hitLabel.text")); // NOI18N
        hitLabel.setToolTipText(bundle.getString("GUI.hitLabel.toolTipText")); // NOI18N
        hitLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        hitLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        hitLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        skaLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        skaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        skaLabel.setText(bundle.getString("GUI.skaLabel.text")); // NOI18N
        skaLabel.setToolTipText(bundle.getString("GUI.skaLabel.toolTipText")); // NOI18N
        skaLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        skaLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        skaLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        endLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        endLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        endLabel.setText(bundle.getString("GUI.endLabel.text")); // NOI18N
        endLabel.setToolTipText(bundle.getString("GUI.endLabel.toolTipText")); // NOI18N
        endLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        endLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        endLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        penLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        penLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        penLabel.setText(bundle.getString("GUI.penLabel.text")); // NOI18N
        penLabel.setToolTipText(bundle.getString("GUI.penLabel.toolTipText")); // NOI18N
        penLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        penLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        penLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        facLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        facLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        facLabel.setText(bundle.getString("GUI.facLabel.text")); // NOI18N
        facLabel.setToolTipText(bundle.getString("GUI.facLabel.toolTipText")); // NOI18N
        facLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        facLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        facLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        leaLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        leaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        leaLabel.setText(bundle.getString("GUI.leaLabel.text")); // NOI18N
        leaLabel.setToolTipText(bundle.getString("GUI.leaLabel.toolTipText")); // NOI18N
        leaLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        leaLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        leaLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        figLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        figLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        figLabel.setText(bundle.getString("GUI.figLabel.text")); // NOI18N
        figLabel.setToolTipText(bundle.getString("GUI.figLabel.toolTipText")); // NOI18N
        figLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        figLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        figLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        strLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        strLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        strLabel.setText(bundle.getString("GUI.strLabel.text")); // NOI18N
        strLabel.setToolTipText(bundle.getString("GUI.strLabel.toolTipText")); // NOI18N
        strLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        strLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        strLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        potLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        potLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        potLabel.setText(bundle.getString("GUI.potLabel.text")); // NOI18N
        potLabel.setToolTipText(bundle.getString("GUI.potLabel.toolTipText")); // NOI18N
        potLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        potLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        potLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        conLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        conLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        conLabel.setText(bundle.getString("GUI.conLabel.text")); // NOI18N
        conLabel.setToolTipText(bundle.getString("GUI.conLabel.toolTipText")); // NOI18N
        conLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        conLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        conLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        grdLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        grdLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        grdLabel.setText(bundle.getString("GUI.grdLabel.text")); // NOI18N
        grdLabel.setToolTipText(bundle.getString("GUI.grdLabel.toolTipText")); // NOI18N
        grdLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        grdLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        grdLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        injLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        injLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        injLabel.setText(bundle.getString("GUI.injLabel.text")); // NOI18N
        injLabel.setToolTipText(bundle.getString("GUI.injLabel.toolTipText")); // NOI18N
        injLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        injLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        injLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        ofLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        ofLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ofLabel.setText(bundle.getString("GUI.ofLabel.text")); // NOI18N
        ofLabel.setToolTipText(bundle.getString("GUI.ofLabel.toolTipText")); // NOI18N
        ofLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ofLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        ofLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        dfLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        dfLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dfLabel.setText(bundle.getString("GUI.dfLabel.text")); // NOI18N
        dfLabel.setToolTipText(bundle.getString("GUI.dfLabel.toolTipText")); // NOI18N
        dfLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dfLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        dfLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        oaLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        oaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oaLabel.setText(bundle.getString("GUI.oaLabel.text")); // NOI18N
        oaLabel.setToolTipText(bundle.getString("GUI.oaLabel.toolTipText")); // NOI18N
        oaLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oaLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        oaLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        curSHO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curSHO.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curSHO.setText(bundle.getString("GUI.curSHO.text")); // NOI18N
        curSHO.setToolTipText(bundle.getString("GUI.curSHO.toolTipText")); // NOI18N
        curSHO.setMaximumSize(new java.awt.Dimension(30, 25));
        curSHO.setMinimumSize(new java.awt.Dimension(30, 25));
        curSHO.setPreferredSize(new java.awt.Dimension(30, 25));
        curSHO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curSHOActionPerformed(evt);
            }
        });

        curPLA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curPLA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curPLA.setText(bundle.getString("GUI.curPLA.text")); // NOI18N
        curPLA.setToolTipText(bundle.getString("GUI.curPLA.toolTipText")); // NOI18N
        curPLA.setMaximumSize(new java.awt.Dimension(30, 25));
        curPLA.setMinimumSize(new java.awt.Dimension(30, 25));
        curPLA.setPreferredSize(new java.awt.Dimension(30, 25));
        curPLA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curPLAActionPerformed(evt);
            }
        });

        curSTK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curSTK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curSTK.setText(bundle.getString("GUI.curSTK.text")); // NOI18N
        curSTK.setToolTipText(bundle.getString("GUI.curSTK.toolTipText")); // NOI18N
        curSTK.setMaximumSize(new java.awt.Dimension(30, 25));
        curSTK.setMinimumSize(new java.awt.Dimension(30, 25));
        curSTK.setPreferredSize(new java.awt.Dimension(30, 25));
        curSTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curSTKActionPerformed(evt);
            }
        });

        curCHK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curCHK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curCHK.setText(bundle.getString("GUI.curCHK.text")); // NOI18N
        curCHK.setToolTipText(bundle.getString("GUI.curCHK.toolTipText")); // NOI18N
        curCHK.setMaximumSize(new java.awt.Dimension(30, 25));
        curCHK.setMinimumSize(new java.awt.Dimension(30, 25));
        curCHK.setPreferredSize(new java.awt.Dimension(30, 25));
        curCHK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curCHKActionPerformed(evt);
            }
        });

        curPOS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curPOS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curPOS.setText(bundle.getString("GUI.curPOS.text")); // NOI18N
        curPOS.setToolTipText(bundle.getString("GUI.curPOS.toolTipText")); // NOI18N
        curPOS.setMaximumSize(new java.awt.Dimension(30, 25));
        curPOS.setMinimumSize(new java.awt.Dimension(30, 25));
        curPOS.setPreferredSize(new java.awt.Dimension(30, 25));
        curPOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curPOSActionPerformed(evt);
            }
        });

        curHIT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curHIT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curHIT.setText(bundle.getString("GUI.curHIT.text")); // NOI18N
        curHIT.setToolTipText(bundle.getString("GUI.curHIT.toolTipText")); // NOI18N
        curHIT.setMaximumSize(new java.awt.Dimension(30, 25));
        curHIT.setMinimumSize(new java.awt.Dimension(30, 25));
        curHIT.setPreferredSize(new java.awt.Dimension(30, 25));
        curHIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curHITActionPerformed(evt);
            }
        });

        curSKA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curSKA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curSKA.setText(bundle.getString("GUI.curSKA.text")); // NOI18N
        curSKA.setToolTipText(bundle.getString("GUI.curSKA.toolTipText")); // NOI18N
        curSKA.setMaximumSize(new java.awt.Dimension(30, 25));
        curSKA.setMinimumSize(new java.awt.Dimension(30, 25));
        curSKA.setPreferredSize(new java.awt.Dimension(30, 25));
        curSKA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curSKAActionPerformed(evt);
            }
        });

        curEND.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curEND.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curEND.setText(bundle.getString("GUI.curEND.text")); // NOI18N
        curEND.setToolTipText(bundle.getString("GUI.curEND.toolTipText")); // NOI18N
        curEND.setMaximumSize(new java.awt.Dimension(30, 25));
        curEND.setMinimumSize(new java.awt.Dimension(30, 25));
        curEND.setPreferredSize(new java.awt.Dimension(30, 25));
        curEND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curENDActionPerformed(evt);
            }
        });

        curPEN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curPEN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curPEN.setText(bundle.getString("GUI.curPEN.text")); // NOI18N
        curPEN.setToolTipText(bundle.getString("GUI.curPEN.toolTipText")); // NOI18N
        curPEN.setMaximumSize(new java.awt.Dimension(30, 25));
        curPEN.setMinimumSize(new java.awt.Dimension(30, 25));
        curPEN.setPreferredSize(new java.awt.Dimension(30, 25));
        curPEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curPENActionPerformed(evt);
            }
        });

        curFAC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curFAC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curFAC.setText(bundle.getString("GUI.curFAC.text")); // NOI18N
        curFAC.setToolTipText(bundle.getString("GUI.curFAC.toolTipText")); // NOI18N
        curFAC.setMaximumSize(new java.awt.Dimension(30, 25));
        curFAC.setMinimumSize(new java.awt.Dimension(30, 25));
        curFAC.setPreferredSize(new java.awt.Dimension(30, 25));
        curFAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curFACActionPerformed(evt);
            }
        });

        curLEA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curLEA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curLEA.setText(bundle.getString("GUI.curLEA.text")); // NOI18N
        curLEA.setToolTipText(bundle.getString("GUI.curLEA.toolTipText")); // NOI18N
        curLEA.setMaximumSize(new java.awt.Dimension(30, 25));
        curLEA.setMinimumSize(new java.awt.Dimension(30, 25));
        curLEA.setPreferredSize(new java.awt.Dimension(30, 25));
        curLEA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curLEAActionPerformed(evt);
            }
        });

        curFIG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curFIG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curFIG.setText(bundle.getString("GUI.curFIG.text")); // NOI18N
        curFIG.setToolTipText(bundle.getString("GUI.curFIG.toolTipText")); // NOI18N
        curFIG.setMaximumSize(new java.awt.Dimension(30, 25));
        curFIG.setMinimumSize(new java.awt.Dimension(30, 25));
        curFIG.setPreferredSize(new java.awt.Dimension(30, 25));
        curFIG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curFIGActionPerformed(evt);
            }
        });

        curSTR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curSTR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curSTR.setText(bundle.getString("GUI.curSTR.text")); // NOI18N
        curSTR.setToolTipText(bundle.getString("GUI.curSTR.toolTipText")); // NOI18N
        curSTR.setMaximumSize(new java.awt.Dimension(30, 25));
        curSTR.setMinimumSize(new java.awt.Dimension(30, 25));
        curSTR.setPreferredSize(new java.awt.Dimension(30, 25));
        curSTR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curSTRActionPerformed(evt);
            }
        });

        POT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        POT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        POT.setText(bundle.getString("GUI.POT.text")); // NOI18N
        POT.setToolTipText(bundle.getString("GUI.POT.toolTipText")); // NOI18N
        POT.setMaximumSize(new java.awt.Dimension(30, 25));
        POT.setMinimumSize(new java.awt.Dimension(30, 25));
        POT.setPreferredSize(new java.awt.Dimension(30, 25));
        POT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                POTActionPerformed(evt);
            }
        });

        CON.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CON.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CON.setText(bundle.getString("GUI.CON.text")); // NOI18N
        CON.setToolTipText(bundle.getString("GUI.CON.toolTipText")); // NOI18N
        CON.setMaximumSize(new java.awt.Dimension(30, 25));
        CON.setMinimumSize(new java.awt.Dimension(30, 25));
        CON.setPreferredSize(new java.awt.Dimension(30, 25));
        CON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CONActionPerformed(evt);
            }
        });

        GRD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        GRD.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        GRD.setText(bundle.getString("GUI.GRD.text")); // NOI18N
        GRD.setToolTipText(bundle.getString("GUI.GRD.toolTipText")); // NOI18N
        GRD.setMaximumSize(new java.awt.Dimension(30, 25));
        GRD.setMinimumSize(new java.awt.Dimension(30, 25));
        GRD.setPreferredSize(new java.awt.Dimension(30, 25));
        GRD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GRDActionPerformed(evt);
            }
        });

        INJ.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        INJ.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        INJ.setText(bundle.getString("GUI.INJ.text")); // NOI18N
        INJ.setToolTipText(bundle.getString("GUI.INJ.toolTipText")); // NOI18N
        INJ.setMaximumSize(new java.awt.Dimension(30, 25));
        INJ.setMinimumSize(new java.awt.Dimension(30, 25));
        INJ.setPreferredSize(new java.awt.Dimension(30, 25));

        curOF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curOF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curOF.setText(bundle.getString("GUI.curOF.text")); // NOI18N
        curOF.setToolTipText(bundle.getString("GUI.curOF.toolTipText")); // NOI18N
        curOF.setMaximumSize(new java.awt.Dimension(30, 25));
        curOF.setMinimumSize(new java.awt.Dimension(30, 25));
        curOF.setPreferredSize(new java.awt.Dimension(30, 25));

        curDF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curDF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curDF.setText(bundle.getString("GUI.curDF.text")); // NOI18N
        curDF.setToolTipText(bundle.getString("GUI.curDF.toolTipText")); // NOI18N
        curDF.setMaximumSize(new java.awt.Dimension(30, 25));
        curDF.setMinimumSize(new java.awt.Dimension(30, 25));
        curDF.setPreferredSize(new java.awt.Dimension(30, 25));

        curOA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curOA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curOA.setText(bundle.getString("GUI.curOA.text")); // NOI18N
        curOA.setToolTipText(bundle.getString("GUI.curOA.toolTipText")); // NOI18N
        curOA.setMaximumSize(new java.awt.Dimension(30, 25));
        curOA.setMinimumSize(new java.awt.Dimension(30, 25));
        curOA.setPreferredSize(new java.awt.Dimension(30, 25));
        curOA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curOAActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(bundle.getString("GUI.jLabel2.text")); // NOI18N
        jLabel2.setToolTipText(bundle.getString("GUI.jLabel2.toolTipText")); // NOI18N
        jLabel2.setMaximumSize(new java.awt.Dimension(30, 25));
        jLabel2.setMinimumSize(new java.awt.Dimension(30, 25));

        salaryAmtConsidering.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        salaryAmtConsidering.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salaryAmtConsidering.setText(bundle.getString("GUI.salaryAmtConsidering.text")); // NOI18N
        salaryAmtConsidering.setToolTipText(bundle.getString("GUI.salaryAmtConsidering.toolTipText")); // NOI18N
        salaryAmtConsidering.setMaximumSize(new java.awt.Dimension(61, 25));
        salaryAmtConsidering.setMinimumSize(new java.awt.Dimension(25, 25));
        salaryAmtConsidering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryAmtConsideringActionPerformed(evt);
            }
        });

        salaryYrConsidering.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        salaryYrConsidering.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salaryYrConsidering.setText(bundle.getString("GUI.salaryYrConsidering.text")); // NOI18N
        salaryYrConsidering.setToolTipText(bundle.getString("GUI.salaryYrConsidering.toolTipText")); // NOI18N
        salaryYrConsidering.setMaximumSize(new java.awt.Dimension(25, 25));
        salaryYrConsidering.setMinimumSize(new java.awt.Dimension(25, 25));
        salaryYrConsidering.setPreferredSize(new java.awt.Dimension(25, 25));
        salaryYrConsidering.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salaryYrConsideringActionPerformed(evt);
            }
        });

        salaryYrLabelConsidering.setFont(new java.awt.Font("Tahoma", 1, 11));
        salaryYrLabelConsidering.setLabelFor(salaryYrConsidering);
        salaryYrLabelConsidering.setText(bundle.getString("GUI.salaryYrLabelConsidering.text")); // NOI18N
        salaryYrLabelConsidering.setToolTipText(bundle.getString("GUI.salaryYrLabelConsidering.toolTipText")); // NOI18N
        salaryYrLabelConsidering.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        salaryAmtLabelConsidering.setFont(new java.awt.Font("Tahoma", 1, 11));
        salaryAmtLabelConsidering.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salaryAmtLabelConsidering.setLabelFor(salaryAmtConsidering);
        salaryAmtLabelConsidering.setText(bundle.getString("GUI.salaryAmtLabelConsidering.text")); // NOI18N
        salaryAmtLabelConsidering.setToolTipText(bundle.getString("GUI.salaryAmtLabelConsidering.toolTipText")); // NOI18N

        ConsideringLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        ConsideringLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ConsideringLabel.setLabelFor(salaryAmtLabel);
        ConsideringLabel.setText(bundle.getString("GUI.ConsideringLabel.text")); // NOI18N
        ConsideringLabel.setToolTipText(bundle.getString("GUI.ConsideringLabel.toolTipText")); // NOI18N

        ceilingLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        ceilingLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ceilingLabel.setText(bundle.getString("GUI.ceilingLabel.text")); // NOI18N
        ceilingLabel.setToolTipText(bundle.getString("GUI.ceilingLabel.toolTipText")); // NOI18N
        ceilingLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilingLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        ceilSHO.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilSHO.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilSHO.setText(bundle.getString("GUI.ceilSHO.text")); // NOI18N
        ceilSHO.setToolTipText(bundle.getString("GUI.ceilSHO.toolTipText")); // NOI18N
        ceilSHO.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilSHO.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilSHO.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilSHO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilSHOActionPerformed(evt);
            }
        });

        ceilPLA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilPLA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilPLA.setText(bundle.getString("GUI.ceilPLA.text")); // NOI18N
        ceilPLA.setToolTipText(bundle.getString("GUI.ceilPLA.toolTipText")); // NOI18N
        ceilPLA.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilPLA.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilPLA.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilPLA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilPLAActionPerformed(evt);
            }
        });

        ceilSTK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilSTK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilSTK.setText(bundle.getString("GUI.ceilSTK.text")); // NOI18N
        ceilSTK.setToolTipText(bundle.getString("GUI.ceilSTK.toolTipText")); // NOI18N
        ceilSTK.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilSTK.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilSTK.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilSTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilSTKActionPerformed(evt);
            }
        });

        ceilCHK.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilCHK.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilCHK.setText(bundle.getString("GUI.ceilCHK.text")); // NOI18N
        ceilCHK.setToolTipText(bundle.getString("GUI.ceilCHK.toolTipText")); // NOI18N
        ceilCHK.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilCHK.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilCHK.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilCHK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilCHKActionPerformed(evt);
            }
        });

        ceilPOS.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilPOS.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilPOS.setText(bundle.getString("GUI.ceilPOS.text")); // NOI18N
        ceilPOS.setToolTipText(bundle.getString("GUI.ceilPOS.toolTipText")); // NOI18N
        ceilPOS.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilPOS.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilPOS.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilPOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilPOSActionPerformed(evt);
            }
        });

        ceilHIT.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilHIT.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilHIT.setText(bundle.getString("GUI.ceilHIT.text")); // NOI18N
        ceilHIT.setToolTipText(bundle.getString("GUI.ceilHIT.toolTipText")); // NOI18N
        ceilHIT.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilHIT.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilHIT.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilHIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilHITActionPerformed(evt);
            }
        });

        ceilSKA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilSKA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilSKA.setText(bundle.getString("GUI.ceilSKA.text")); // NOI18N
        ceilSKA.setToolTipText(bundle.getString("GUI.ceilSKA.toolTipText")); // NOI18N
        ceilSKA.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilSKA.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilSKA.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilSKA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilSKAActionPerformed(evt);
            }
        });

        ceilEND.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilEND.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilEND.setText(bundle.getString("GUI.ceilEND.text")); // NOI18N
        ceilEND.setToolTipText(bundle.getString("GUI.ceilEND.toolTipText")); // NOI18N
        ceilEND.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilEND.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilEND.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilEND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilENDActionPerformed(evt);
            }
        });

        ceilPEN.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilPEN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilPEN.setText(bundle.getString("GUI.ceilPEN.text")); // NOI18N
        ceilPEN.setToolTipText(bundle.getString("GUI.ceilPEN.toolTipText")); // NOI18N
        ceilPEN.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilPEN.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilPEN.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilPEN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilPENActionPerformed(evt);
            }
        });

        ceilFAC.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilFAC.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilFAC.setText(bundle.getString("GUI.ceilFAC.text")); // NOI18N
        ceilFAC.setToolTipText(bundle.getString("GUI.ceilFAC.toolTipText")); // NOI18N
        ceilFAC.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilFAC.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilFAC.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilFAC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilFACActionPerformed(evt);
            }
        });

        ceilLEA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilLEA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilLEA.setText(bundle.getString("GUI.ceilLEA.text")); // NOI18N
        ceilLEA.setToolTipText(bundle.getString("GUI.ceilLEA.toolTipText")); // NOI18N
        ceilLEA.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilLEA.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilLEA.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilLEA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilLEAActionPerformed(evt);
            }
        });

        ceilFIG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilFIG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilFIG.setText(bundle.getString("GUI.ceilFIG.text")); // NOI18N
        ceilFIG.setToolTipText(bundle.getString("GUI.ceilFIG.toolTipText")); // NOI18N
        ceilFIG.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilFIG.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilFIG.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilFIG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilFIGActionPerformed(evt);
            }
        });

        ceilSTR.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilSTR.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilSTR.setText(bundle.getString("GUI.ceilSTR.text")); // NOI18N
        ceilSTR.setToolTipText(bundle.getString("GUI.ceilSTR.toolTipText")); // NOI18N
        ceilSTR.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilSTR.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilSTR.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilSTR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilSTRActionPerformed(evt);
            }
        });

        ceilSHO1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilSHO1.setEditable(false);
        ceilSHO1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilSHO1.setText(bundle.getString("GUI.ceilSHO1.text")); // NOI18N
        ceilSHO1.setToolTipText(bundle.getString("GUI.ceilSHO1.toolTipText")); // NOI18N
        ceilSHO1.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilSHO1.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilSHO1.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilSHO1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilSHO1ActionPerformed(evt);
            }
        });

        ceilPLA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilPLA1.setEditable(false);
        ceilPLA1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilPLA1.setText(bundle.getString("GUI.ceilPLA1.text")); // NOI18N
        ceilPLA1.setToolTipText(bundle.getString("GUI.ceilPLA1.toolTipText")); // NOI18N
        ceilPLA1.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilPLA1.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilPLA1.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilPLA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilPLA1ActionPerformed(evt);
            }
        });

        ceilSTK1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilSTK1.setEditable(false);
        ceilSTK1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilSTK1.setText(bundle.getString("GUI.ceilSTK1.text")); // NOI18N
        ceilSTK1.setToolTipText(bundle.getString("GUI.ceilSTK1.toolTipText")); // NOI18N
        ceilSTK1.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilSTK1.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilSTK1.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilSTK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilSTK1ActionPerformed(evt);
            }
        });

        ceilCHK1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilCHK1.setEditable(false);
        ceilCHK1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilCHK1.setText(bundle.getString("GUI.ceilCHK1.text")); // NOI18N
        ceilCHK1.setToolTipText(bundle.getString("GUI.ceilCHK1.toolTipText")); // NOI18N
        ceilCHK1.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilCHK1.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilCHK1.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilCHK1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilCHK1ActionPerformed(evt);
            }
        });

        ceilPOS1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilPOS1.setEditable(false);
        ceilPOS1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilPOS1.setText(bundle.getString("GUI.ceilPOS1.text")); // NOI18N
        ceilPOS1.setToolTipText(bundle.getString("GUI.ceilPOS1.toolTipText")); // NOI18N
        ceilPOS1.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilPOS1.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilPOS1.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilPOS1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilPOS1ActionPerformed(evt);
            }
        });

        ceilHIT1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilHIT1.setEditable(false);
        ceilHIT1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilHIT1.setText(bundle.getString("GUI.ceilHIT1.text")); // NOI18N
        ceilHIT1.setToolTipText(bundle.getString("GUI.ceilHIT1.toolTipText")); // NOI18N
        ceilHIT1.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilHIT1.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilHIT1.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilHIT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilHIT1ActionPerformed(evt);
            }
        });

        ceilSKA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilSKA1.setEditable(false);
        ceilSKA1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilSKA1.setText(bundle.getString("GUI.ceilSKA1.text")); // NOI18N
        ceilSKA1.setToolTipText(bundle.getString("GUI.ceilSKA1.toolTipText")); // NOI18N
        ceilSKA1.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilSKA1.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilSKA1.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilSKA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilSKA1ActionPerformed(evt);
            }
        });

        ceilEND1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilEND1.setEditable(false);
        ceilEND1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilEND1.setText(bundle.getString("GUI.ceilEND1.text")); // NOI18N
        ceilEND1.setToolTipText(bundle.getString("GUI.ceilEND1.toolTipText")); // NOI18N
        ceilEND1.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilEND1.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilEND1.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilEND1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilEND1ActionPerformed(evt);
            }
        });

        ceilPEN1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilPEN1.setEditable(false);
        ceilPEN1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilPEN1.setText(bundle.getString("GUI.ceilPEN1.text")); // NOI18N
        ceilPEN1.setToolTipText(bundle.getString("GUI.ceilPEN1.toolTipText")); // NOI18N
        ceilPEN1.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilPEN1.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilPEN1.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilPEN1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilPEN1ActionPerformed(evt);
            }
        });

        ceilFAC1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilFAC1.setEditable(false);
        ceilFAC1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilFAC1.setText(bundle.getString("GUI.ceilFAC1.text")); // NOI18N
        ceilFAC1.setToolTipText(bundle.getString("GUI.ceilFAC1.toolTipText")); // NOI18N
        ceilFAC1.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilFAC1.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilFAC1.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilFAC1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilFAC1ActionPerformed(evt);
            }
        });

        ceilLEA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilLEA1.setEditable(false);
        ceilLEA1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilLEA1.setText(bundle.getString("GUI.ceilLEA1.text")); // NOI18N
        ceilLEA1.setToolTipText(bundle.getString("GUI.ceilLEA1.toolTipText")); // NOI18N
        ceilLEA1.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilLEA1.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilLEA1.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilLEA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilLEA1ActionPerformed(evt);
            }
        });

        ceilFIG1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilFIG1.setEditable(false);
        ceilFIG1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilFIG1.setText(bundle.getString("GUI.ceilFIG1.text")); // NOI18N
        ceilFIG1.setToolTipText(bundle.getString("GUI.ceilFIG1.toolTipText")); // NOI18N
        ceilFIG1.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilFIG1.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilFIG1.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilFIG1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilFIG1ActionPerformed(evt);
            }
        });

        ceilSTR1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ceilSTR1.setEditable(false);
        ceilSTR1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ceilSTR1.setText(bundle.getString("GUI.ceilSTR1.text")); // NOI18N
        ceilSTR1.setToolTipText(bundle.getString("GUI.ceilSTR1.toolTipText")); // NOI18N
        ceilSTR1.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilSTR1.setMinimumSize(new java.awt.Dimension(30, 25));
        ceilSTR1.setPreferredSize(new java.awt.Dimension(30, 25));
        ceilSTR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ceilSTR1ActionPerformed(evt);
            }
        });

        ceilingLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        ceilingLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ceilingLabel1.setText(bundle.getString("GUI.ceilingLabel1.text")); // NOI18N
        ceilingLabel1.setToolTipText(bundle.getString("GUI.ceilingLabel1.toolTipText")); // NOI18N
        ceilingLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilingLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        projOF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projOF.setEditable(false);
        projOF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        projOF.setText(bundle.getString("GUI.projOF.text")); // NOI18N
        projOF.setToolTipText(bundle.getString("GUI.projOF.toolTipText")); // NOI18N
        projOF.setMaximumSize(new java.awt.Dimension(30, 25));
        projOF.setMinimumSize(new java.awt.Dimension(30, 25));
        projOF.setPreferredSize(new java.awt.Dimension(30, 25));

        projDF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projDF.setEditable(false);
        projDF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        projDF.setText(bundle.getString("GUI.projDF.text")); // NOI18N
        projDF.setToolTipText(bundle.getString("GUI.projDF.toolTipText")); // NOI18N
        projDF.setMaximumSize(new java.awt.Dimension(30, 25));
        projDF.setMinimumSize(new java.awt.Dimension(30, 25));
        projDF.setPreferredSize(new java.awt.Dimension(30, 25));

        projOA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projOA.setEditable(false);
        projOA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        projOA.setText(bundle.getString("GUI.projOA.text")); // NOI18N
        projOA.setToolTipText(bundle.getString("GUI.projOA.toolTipText")); // NOI18N
        projOA.setMaximumSize(new java.awt.Dimension(30, 25));
        projOA.setMinimumSize(new java.awt.Dimension(30, 25));
        projOA.setPreferredSize(new java.awt.Dimension(30, 25));
        projOA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projOAActionPerformed(evt);
            }
        });

        trainOF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        trainOF.setEditable(false);
        trainOF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        trainOF.setText(bundle.getString("GUI.trainOF.text")); // NOI18N
        trainOF.setToolTipText(bundle.getString("GUI.trainOF.toolTipText")); // NOI18N
        trainOF.setMaximumSize(new java.awt.Dimension(30, 25));
        trainOF.setMinimumSize(new java.awt.Dimension(30, 25));
        trainOF.setPreferredSize(new java.awt.Dimension(30, 25));

        trainDF.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        trainDF.setEditable(false);
        trainDF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        trainDF.setText(bundle.getString("GUI.trainDF.text")); // NOI18N
        trainDF.setToolTipText(bundle.getString("GUI.trainDF.toolTipText")); // NOI18N
        trainDF.setMaximumSize(new java.awt.Dimension(30, 25));
        trainDF.setMinimumSize(new java.awt.Dimension(30, 25));
        trainDF.setPreferredSize(new java.awt.Dimension(30, 25));

        trainOA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        trainOA.setEditable(false);
        trainOA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        trainOA.setText(bundle.getString("GUI.trainOA.text")); // NOI18N
        trainOA.setToolTipText(bundle.getString("GUI.trainOA.toolTipText")); // NOI18N
        trainOA.setMaximumSize(new java.awt.Dimension(30, 25));
        trainOA.setMinimumSize(new java.awt.Dimension(30, 25));
        trainOA.setPreferredSize(new java.awt.Dimension(30, 25));
        trainOA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainOAActionPerformed(evt);
            }
        });

        ceilingLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        ceilingLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ceilingLabel2.setText(bundle.getString("GUI.ceilingLabel2.text")); // NOI18N
        ceilingLabel2.setToolTipText(bundle.getString("GUI.ceilingLabel2.toolTipText")); // NOI18N
        ceilingLabel2.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilingLabel2.setMinimumSize(new java.awt.Dimension(30, 25));

        farmOF1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        farmOF1.setEditable(false);
        farmOF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        farmOF1.setText(bundle.getString("GUI.farmOF1.text")); // NOI18N
        farmOF1.setToolTipText(bundle.getString("GUI.farmOF1.toolTipText")); // NOI18N
        farmOF1.setMaximumSize(new java.awt.Dimension(30, 25));
        farmOF1.setMinimumSize(new java.awt.Dimension(30, 25));
        farmOF1.setPreferredSize(new java.awt.Dimension(30, 25));

        farmDF1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        farmDF1.setEditable(false);
        farmDF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        farmDF1.setText(bundle.getString("GUI.farmDF1.text")); // NOI18N
        farmDF1.setToolTipText(bundle.getString("GUI.farmDF1.toolTipText")); // NOI18N
        farmDF1.setMaximumSize(new java.awt.Dimension(30, 25));
        farmDF1.setMinimumSize(new java.awt.Dimension(30, 25));
        farmDF1.setPreferredSize(new java.awt.Dimension(30, 25));

        farmOA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        farmOA1.setEditable(false);
        farmOA1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        farmOA1.setText(bundle.getString("GUI.farmOA1.text")); // NOI18N
        farmOA1.setToolTipText(bundle.getString("GUI.farmOA1.toolTipText")); // NOI18N
        farmOA1.setMaximumSize(new java.awt.Dimension(30, 25));
        farmOA1.setMinimumSize(new java.awt.Dimension(30, 25));
        farmOA1.setPreferredSize(new java.awt.Dimension(30, 25));
        farmOA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                farmOA1ActionPerformed(evt);
            }
        });

        ceilingLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        ceilingLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ceilingLabel3.setText(bundle.getString("GUI.ceilingLabel3.text")); // NOI18N
        ceilingLabel3.setToolTipText(bundle.getString("GUI.ceilingLabel3.toolTipText")); // NOI18N
        ceilingLabel3.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilingLabel3.setMinimumSize(new java.awt.Dimension(30, 25));

        status.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        status.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        status.setText(bundle.getString("GUI.status.text")); // NOI18N
        status.setToolTipText(bundle.getString("GUI.status.toolTipText")); // NOI18N
        status.setMaximumSize(new java.awt.Dimension(25, 25));
        status.setMinimumSize(new java.awt.Dimension(25, 25));
        status.setPreferredSize(new java.awt.Dimension(7, 25));
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        statusLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusLabel.setLabelFor(status);
        statusLabel.setText(bundle.getString("GUI.statusLabel.text")); // NOI18N
        statusLabel.setToolTipText(bundle.getString("GUI.statusLabel.toolTipText")); // NOI18N

        similarPlayerList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "No Matches" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        similarPlayerList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        similarPlayerList.setToolTipText(bundle.getString("GUI.similarPlayerList.toolTipText")); // NOI18N
        similarPlayerList.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        similarPlayerList.setSelectionBackground(new java.awt.Color(120, 210, 120));
        similarPlayerList.setValueIsAdjusting(true);
        similarPlayerList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                similarPlayerListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(similarPlayerList);

        weeklyLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        weeklyLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weeklyLabel.setText(bundle.getString("GUI.weeklyLabel.text")); // NOI18N
        weeklyLabel.setToolTipText(bundle.getString("GUI.weeklyLabel4.toolTipText")); // NOI18N
        weeklyLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        weeklyLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        shoLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        shoLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        shoLabel1.setText(bundle.getString("GUI.shoLabel1.text")); // NOI18N
        shoLabel1.setToolTipText(bundle.getString("GUI.shoLabel1.toolTipText")); // NOI18N
        shoLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        shoLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        gLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        gLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gLabel.setText(bundle.getString("GUI.gLabel.text")); // NOI18N
        gLabel.setToolTipText(bundle.getString("GUI.gLabel.toolTipText")); // NOI18N
        gLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        gLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        assistLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        assistLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        assistLabel.setText(bundle.getString("GUI.assistLabel.text")); // NOI18N
        assistLabel.setToolTipText(bundle.getString("GUI.assistLabel.toolTipText")); // NOI18N
        assistLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        assistLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        pLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        pLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pLabel.setText(bundle.getString("GUI.pLabel.text")); // NOI18N
        pLabel.setToolTipText(bundle.getString("GUI.pLabel.toolTipText")); // NOI18N
        pLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        pLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        gwgLabel.setFont(new java.awt.Font("Tahoma", 1, 12));
        gwgLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        gwgLabel.setText(bundle.getString("GUI.gwgLabel.text")); // NOI18N
        gwgLabel.setToolTipText(bundle.getString("GUI.gwgLabel.toolTipText")); // NOI18N
        gwgLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        gwgLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        wGP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        wGP.setEditable(false);
        wGP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wGP.setText(bundle.getString("GUI.wGP.text")); // NOI18N
        wGP.setToolTipText(bundle.getString("GUI.wGP.toolTipText")); // NOI18N
        wGP.setMaximumSize(new java.awt.Dimension(30, 25));
        wGP.setMinimumSize(new java.awt.Dimension(30, 25));
        wGP.setPreferredSize(new java.awt.Dimension(30, 25));

        wG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        wG.setEditable(false);
        wG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wG.setText(bundle.getString("GUI.wG.text")); // NOI18N
        wG.setToolTipText(bundle.getString("GUI.wG.toolTipText")); // NOI18N
        wG.setMaximumSize(new java.awt.Dimension(30, 25));
        wG.setMinimumSize(new java.awt.Dimension(30, 25));
        wG.setPreferredSize(new java.awt.Dimension(30, 25));

        wA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        wA.setEditable(false);
        wA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wA.setText(bundle.getString("GUI.wA.text")); // NOI18N
        wA.setToolTipText(bundle.getString("GUI.wA.toolTipText")); // NOI18N
        wA.setMaximumSize(new java.awt.Dimension(30, 25));
        wA.setMinimumSize(new java.awt.Dimension(30, 25));
        wA.setPreferredSize(new java.awt.Dimension(30, 25));

        wP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        wP.setEditable(false);
        wP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wP.setText(bundle.getString("GUI.wP.text")); // NOI18N
        wP.setToolTipText(bundle.getString("GUI.wP.toolTipText")); // NOI18N
        wP.setMaximumSize(new java.awt.Dimension(30, 25));
        wP.setMinimumSize(new java.awt.Dimension(30, 25));
        wP.setPreferredSize(new java.awt.Dimension(30, 25));

        wGWG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        wGWG.setEditable(false);
        wGWG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wGWG.setText(bundle.getString("GUI.wGWG.text")); // NOI18N
        wGWG.setToolTipText(bundle.getString("GUI.wGWG.toolTipText")); // NOI18N
        wGWG.setMaximumSize(new java.awt.Dimension(30, 25));
        wGWG.setMinimumSize(new java.awt.Dimension(30, 25));
        wGWG.setPreferredSize(new java.awt.Dimension(30, 25));

        weeklyLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        weeklyLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weeklyLabel1.setText(bundle.getString("GUI.weeklyLabel1.text")); // NOI18N
        weeklyLabel1.setToolTipText(bundle.getString("GUI.weeklyLabel4.toolTipText")); // NOI18N
        weeklyLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        weeklyLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        mGP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mGP.setEditable(false);
        mGP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mGP.setText(bundle.getString("GUI.mGP.text")); // NOI18N
        mGP.setToolTipText(bundle.getString("GUI.mGP.toolTipText")); // NOI18N
        mGP.setMaximumSize(new java.awt.Dimension(30, 25));
        mGP.setMinimumSize(new java.awt.Dimension(30, 25));
        mGP.setPreferredSize(new java.awt.Dimension(30, 25));

        mG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mG.setEditable(false);
        mG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mG.setText(bundle.getString("GUI.mG.text")); // NOI18N
        mG.setToolTipText(bundle.getString("GUI.mG.toolTipText")); // NOI18N
        mG.setMaximumSize(new java.awt.Dimension(30, 25));
        mG.setMinimumSize(new java.awt.Dimension(30, 25));
        mG.setPreferredSize(new java.awt.Dimension(30, 25));

        mA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mA.setEditable(false);
        mA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mA.setText(bundle.getString("GUI.mA.text")); // NOI18N
        mA.setToolTipText(bundle.getString("GUI.mA.toolTipText")); // NOI18N
        mA.setMaximumSize(new java.awt.Dimension(30, 25));
        mA.setMinimumSize(new java.awt.Dimension(30, 25));
        mA.setPreferredSize(new java.awt.Dimension(30, 25));

        mP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mP.setEditable(false);
        mP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mP.setText(bundle.getString("GUI.mP.text")); // NOI18N
        mP.setToolTipText(bundle.getString("GUI.mP.toolTipText")); // NOI18N
        mP.setMaximumSize(new java.awt.Dimension(30, 25));
        mP.setMinimumSize(new java.awt.Dimension(30, 25));
        mP.setPreferredSize(new java.awt.Dimension(30, 25));

        mGWG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        mGWG.setEditable(false);
        mGWG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        mGWG.setText(bundle.getString("GUI.mGWG.text")); // NOI18N
        mGWG.setToolTipText(bundle.getString("GUI.mGWG.toolTipText")); // NOI18N
        mGWG.setMaximumSize(new java.awt.Dimension(30, 25));
        mGWG.setMinimumSize(new java.awt.Dimension(30, 25));
        mGWG.setPreferredSize(new java.awt.Dimension(30, 25));

        weeklyLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        weeklyLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weeklyLabel2.setText(bundle.getString("GUI.weeklyLabel2.text")); // NOI18N
        weeklyLabel2.setToolTipText(bundle.getString("GUI.weeklyLabel4.toolTipText")); // NOI18N
        weeklyLabel2.setMaximumSize(new java.awt.Dimension(30, 25));
        weeklyLabel2.setMinimumSize(new java.awt.Dimension(30, 25));

        curStreakGP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curStreakGP.setEditable(false);
        curStreakGP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curStreakGP.setText(bundle.getString("GUI.curStreakGP.text")); // NOI18N
        curStreakGP.setToolTipText(bundle.getString("GUI.curStreakGP.toolTipText")); // NOI18N
        curStreakGP.setMaximumSize(new java.awt.Dimension(30, 25));
        curStreakGP.setMinimumSize(new java.awt.Dimension(30, 25));
        curStreakGP.setPreferredSize(new java.awt.Dimension(30, 25));

        curStreakG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curStreakG.setEditable(false);
        curStreakG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curStreakG.setText(bundle.getString("GUI.curStreakG.text")); // NOI18N
        curStreakG.setToolTipText(bundle.getString("GUI.curStreakG.toolTipText")); // NOI18N
        curStreakG.setMaximumSize(new java.awt.Dimension(30, 25));
        curStreakG.setMinimumSize(new java.awt.Dimension(30, 25));
        curStreakG.setPreferredSize(new java.awt.Dimension(30, 25));

        curStreakP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curStreakP.setEditable(false);
        curStreakP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curStreakP.setText(bundle.getString("GUI.curStreakP.text")); // NOI18N
        curStreakP.setToolTipText(bundle.getString("GUI.curStreakP.toolTipText")); // NOI18N
        curStreakP.setMaximumSize(new java.awt.Dimension(30, 25));
        curStreakP.setMinimumSize(new java.awt.Dimension(30, 25));
        curStreakP.setPreferredSize(new java.awt.Dimension(30, 25));

        weeklyLabel3.setFont(new java.awt.Font("Tahoma", 1, 11));
        weeklyLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weeklyLabel3.setText(bundle.getString("GUI.weeklyLabel3.text")); // NOI18N
        weeklyLabel3.setToolTipText(bundle.getString("GUI.weeklyLabel4.toolTipText")); // NOI18N
        weeklyLabel3.setMaximumSize(new java.awt.Dimension(30, 25));
        weeklyLabel3.setMinimumSize(new java.awt.Dimension(30, 25));

        bStreakGP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bStreakGP.setEditable(false);
        bStreakGP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bStreakGP.setText(bundle.getString("GUI.bStreakGP.text")); // NOI18N
        bStreakGP.setToolTipText(bundle.getString("GUI.bStreakGP.toolTipText")); // NOI18N
        bStreakGP.setMaximumSize(new java.awt.Dimension(30, 25));
        bStreakGP.setMinimumSize(new java.awt.Dimension(30, 25));
        bStreakGP.setPreferredSize(new java.awt.Dimension(30, 25));

        bStreakG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bStreakG.setEditable(false);
        bStreakG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bStreakG.setText(bundle.getString("GUI.bStreakG.text")); // NOI18N
        bStreakG.setToolTipText(bundle.getString("GUI.bStreakG.toolTipText")); // NOI18N
        bStreakG.setMaximumSize(new java.awt.Dimension(30, 25));
        bStreakG.setMinimumSize(new java.awt.Dimension(30, 25));
        bStreakG.setPreferredSize(new java.awt.Dimension(30, 25));

        bStreakA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bStreakA.setEditable(false);
        bStreakA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bStreakA.setText(bundle.getString("GUI.bStreakA.text")); // NOI18N
        bStreakA.setToolTipText(bundle.getString("GUI.bStreakA.toolTipText")); // NOI18N
        bStreakA.setMaximumSize(new java.awt.Dimension(30, 25));
        bStreakA.setMinimumSize(new java.awt.Dimension(30, 25));
        bStreakA.setPreferredSize(new java.awt.Dimension(30, 25));

        bStreakP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bStreakP.setEditable(false);
        bStreakP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bStreakP.setText(bundle.getString("GUI.bStreakP.text")); // NOI18N
        bStreakP.setToolTipText(bundle.getString("GUI.bStreakP.toolTipText")); // NOI18N
        bStreakP.setMaximumSize(new java.awt.Dimension(30, 25));
        bStreakP.setMinimumSize(new java.awt.Dimension(30, 25));
        bStreakP.setPreferredSize(new java.awt.Dimension(30, 25));

        bStreakGWG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        bStreakGWG.setEditable(false);
        bStreakGWG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        bStreakGWG.setText(bundle.getString("GUI.bStreakGWG.text")); // NOI18N
        bStreakGWG.setToolTipText(bundle.getString("GUI.bStreakGWG.toolTipText")); // NOI18N
        bStreakGWG.setMaximumSize(new java.awt.Dimension(30, 25));
        bStreakGWG.setMinimumSize(new java.awt.Dimension(30, 25));
        bStreakGWG.setPreferredSize(new java.awt.Dimension(30, 25));

        careerG.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        careerG.setEditable(false);
        careerG.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        careerG.setText(bundle.getString("GUI.careerG.text")); // NOI18N
        careerG.setToolTipText(bundle.getString("GUI.careerG.toolTipText")); // NOI18N
        careerG.setMaximumSize(new java.awt.Dimension(30, 25));
        careerG.setMinimumSize(new java.awt.Dimension(30, 25));
        careerG.setPreferredSize(new java.awt.Dimension(30, 25));

        careerA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        careerA.setEditable(false);
        careerA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        careerA.setText(bundle.getString("GUI.careerA.text")); // NOI18N
        careerA.setToolTipText(bundle.getString("GUI.careerA.toolTipText")); // NOI18N
        careerA.setMaximumSize(new java.awt.Dimension(30, 25));
        careerA.setMinimumSize(new java.awt.Dimension(30, 25));
        careerA.setPreferredSize(new java.awt.Dimension(30, 25));

        careerP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        careerP.setEditable(false);
        careerP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        careerP.setText(bundle.getString("GUI.careerP.text")); // NOI18N
        careerP.setToolTipText(bundle.getString("GUI.careerP.toolTipText")); // NOI18N
        careerP.setMaximumSize(new java.awt.Dimension(30, 25));
        careerP.setMinimumSize(new java.awt.Dimension(30, 25));
        careerP.setPreferredSize(new java.awt.Dimension(30, 25));

        weeklyLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        weeklyLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        weeklyLabel4.setText(bundle.getString("GUI.weeklyLabel4.text")); // NOI18N
        weeklyLabel4.setToolTipText(bundle.getString("GUI.weeklyLabel4.toolTipText")); // NOI18N
        weeklyLabel4.setMaximumSize(new java.awt.Dimension(30, 25));
        weeklyLabel4.setMinimumSize(new java.awt.Dimension(30, 25));

        similarPlayerLabel.setFont(new java.awt.Font("Tahoma", 1, 11));
        similarPlayerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        similarPlayerLabel.setText(bundle.getString("GUI.similarPlayerLabel.text")); // NOI18N
        similarPlayerLabel.setToolTipText(bundle.getString("GUI.similarPlayerLabel.toolTipText")); // NOI18N
        similarPlayerLabel.setMaximumSize(new java.awt.Dimension(30, 25));
        similarPlayerLabel.setMinimumSize(new java.awt.Dimension(30, 25));

        playerID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        playerID.setText(bundle.getString("GUI.playerID.text")); // NOI18N

        playerTypeP1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        playerTypeP1.setEditable(false);
        playerTypeP1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        playerTypeP1.setText(bundle.getString("GUI.playerTypeP1.text")); // NOI18N
        playerTypeP1.setToolTipText(bundle.getString("GUI.playerTypeP1.toolTipText")); // NOI18N

        playerTypeP2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        playerTypeP2.setEditable(false);
        playerTypeP2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        playerTypeP2.setText(bundle.getString("GUI.playerTypeP2.text")); // NOI18N
        playerTypeP2.setToolTipText(bundle.getString("GUI.playerTypeP2.toolTipText")); // NOI18N

        javax.swing.GroupLayout playerPanelLayout = new javax.swing.GroupLayout(playerPanel);
        playerPanel.setLayout(playerPanelLayout);
        playerPanelLayout.setHorizontalGroup(
            playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerPanelLayout.createSequentialGroup()
                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(playerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(draftHeaderLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerPanelLayout.createSequentialGroup()
                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(shoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(playerPanelLayout.createSequentialGroup()
                                    .addComponent(rightsField, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(draftYr, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(draftRd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(draftPos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(playerPanelLayout.createSequentialGroup()
                                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(playerPanelLayout.createSequentialGroup()
                                            .addGap(19, 19, 19)
                                            .addComponent(ceilingLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerPanelLayout.createSequentialGroup()
                                            .addContainerGap()
                                            .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(weeklyLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                                .addComponent(weeklyLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                                .addComponent(ceilingLabel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE))
                                            .addGap(26, 26, 26)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(curSHO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ceilSHO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(ceilSHO1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(shoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(wGP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(mGP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(playerPanelLayout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addComponent(weeklyLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(curStreakGP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(playerPanelLayout.createSequentialGroup()
                                    .addGap(20, 20, 20)
                                    .addComponent(weeklyLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                                    .addComponent(bStreakGP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(playerPanelLayout.createSequentialGroup()
                                    .addGap(31, 31, 31)
                                    .addComponent(weeklyLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addComponent(rightsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(draftLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(draftTeamLabel)
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addComponent(careerG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(careerA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addComponent(bStreakG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bStreakA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(curStreakG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addComponent(mG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addComponent(wG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(wA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addComponent(gLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(assistLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addComponent(curPLA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(curSTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addComponent(plaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(stkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ceilPLA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(ceilSTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ceilPLA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(ceilSTK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(draftTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(playerPanelLayout.createSequentialGroup()
                                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(playerPanelLayout.createSequentialGroup()
                                                .addComponent(salaryYr, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(salaryAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(playerPanelLayout.createSequentialGroup()
                                                .addComponent(salaryYrLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(salaryAmtLabel))))
                                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(playerPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(twoWayLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(twoWay, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(playerPanelLayout.createSequentialGroup()
                                                        .addComponent(salaryYrConsidering, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(6, 6, 6)
                                                        .addComponent(salaryAmtConsidering, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(playerPanelLayout.createSequentialGroup()
                                                        .addComponent(salaryYrLabelConsidering)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(salaryAmtLabelConsidering)))
                                                .addGap(5, 5, 5))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerPanelLayout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(ConsideringLabel)
                                                .addGap(27, 27, 27))))
                                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(playerPanelLayout.createSequentialGroup()
                                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(height, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(heightLabel))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, playerPanelLayout.createSequentialGroup()
                                                .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(age, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(playerPanelLayout.createSequentialGroup()
                                                .addComponent(weightLabel)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(countryLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(hand, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(handLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(playerPanelLayout.createSequentialGroup()
                                        .addComponent(searchPlayer)
                                        .addGap(33, 33, 33)
                                        .addComponent(playerTypeP1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(playerTypeP2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(playerPanelLayout.createSequentialGroup()
                                        .addComponent(click, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(playerPanelLayout.createSequentialGroup()
                                            .addComponent(mainPOSI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(altPOSI, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(playerPanelLayout.createSequentialGroup()
                                            .addComponent(clickLabel)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(statusLabel))))
                                .addGap(74, 74, 74))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addComponent(chkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(posLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(hitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(skaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(endLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(penLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(facLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(leaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(figLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(strLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(potLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(conLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(grdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(injLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ofLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dfLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(oaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addComponent(ceilCHK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(576, 576, 576))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(ceilPOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(540, 540, 540))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(ceilHIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(504, 504, 504))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(ceilSKA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(468, 468, 468))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(ceilEND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(432, 432, 432))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addGap(180, 180, 180)
                                .addComponent(ceilPEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(396, 396, 396))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addGap(216, 216, 216)
                                .addComponent(ceilFAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(360, 360, 360))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addGap(252, 252, 252)
                                .addComponent(ceilLEA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(324, 324, 324))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addGap(288, 288, 288)
                                .addComponent(ceilFIG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(288, 288, 288))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addGap(324, 324, 324)
                                .addComponent(ceilSTR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(252, 252, 252))
                            .addGroup(playerPanelLayout.createSequentialGroup()
                                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(playerPanelLayout.createSequentialGroup()
                                            .addComponent(wP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(wGWG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ceilingLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(playerPanelLayout.createSequentialGroup()
                                            .addComponent(pLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(gwgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(ceilingLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(playerPanelLayout.createSequentialGroup()
                                                .addComponent(curCHK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(curPOS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(curHIT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(curSKA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(curEND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(curPEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(curFAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(curLEA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(curFIG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(curSTR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(POT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(CON, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(GRD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(INJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(ceilCHK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(playerPanelLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(ceilPOS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(playerPanelLayout.createSequentialGroup()
                                                .addGap(72, 72, 72)
                                                .addComponent(ceilHIT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(playerPanelLayout.createSequentialGroup()
                                                .addGap(108, 108, 108)
                                                .addComponent(ceilSKA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(playerPanelLayout.createSequentialGroup()
                                                .addGap(144, 144, 144)
                                                .addComponent(ceilEND1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(playerPanelLayout.createSequentialGroup()
                                                .addGap(180, 180, 180)
                                                .addComponent(ceilPEN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(playerPanelLayout.createSequentialGroup()
                                                .addGap(216, 216, 216)
                                                .addComponent(ceilFAC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(playerPanelLayout.createSequentialGroup()
                                                .addGap(252, 252, 252)
                                                .addComponent(ceilLEA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(playerPanelLayout.createSequentialGroup()
                                                .addGap(324, 324, 324)
                                                .addComponent(ceilSTR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(playerPanelLayout.createSequentialGroup()
                                                .addGap(288, 288, 288)
                                                .addComponent(ceilFIG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, playerPanelLayout.createSequentialGroup()
                                            .addComponent(curStreakP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(similarPlayerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(playerPanelLayout.createSequentialGroup()
                                        .addComponent(mP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(mGWG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(playerPanelLayout.createSequentialGroup()
                                        .addComponent(bStreakP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(bStreakGWG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(playerPanelLayout.createSequentialGroup()
                                        .addComponent(projOF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(projDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(projOA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(playerPanelLayout.createSequentialGroup()
                                        .addComponent(curOF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(curDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(curOA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(playerPanelLayout.createSequentialGroup()
                                        .addComponent(trainOF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(trainDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(trainOA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(farmOF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(playerPanelLayout.createSequentialGroup()
                                        .addGap(72, 72, 72)
                                        .addComponent(farmOA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(playerPanelLayout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(farmDF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(180, 180, 180))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(careerP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(playerPanelLayout.createSequentialGroup()
                .addComponent(playerID, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1088, Short.MAX_VALUE))
        );
        playerPanelLayout.setVerticalGroup(
            playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerPanelLayout.createSequentialGroup()
                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(playerIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(draftHeaderLabel)
                            .addComponent(ConsideringLabel)))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchPlayer)
                            .addComponent(mainPOSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(altPOSI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerTypeP1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerTypeP2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rightsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(salaryAmtLabel)
                    .addComponent(salaryYrLabel)
                    .addComponent(twoWayLabel)
                    .addComponent(ageLabel)
                    .addComponent(weightLabel)
                    .addComponent(heightLabel)
                    .addComponent(salaryYrLabelConsidering)
                    .addComponent(salaryAmtLabelConsidering)
                    .addComponent(countryLabel)
                    .addComponent(handLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(clickLabel)
                    .addComponent(statusLabel)
                    .addComponent(draftTeamLabel)
                    .addComponent(draftLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(draftYr, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(draftRd, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(draftPos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(draftTeam, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rightsField, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(salaryYr, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(salaryAmt, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(twoWay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(weight, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(height, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(salaryYrConsidering, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(salaryAmtConsidering, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(country, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(hand, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(click, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(plaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(posLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hitLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(skaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(penLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(facLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(leaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(figLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(strLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(potLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(conLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(grdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(injLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ofLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dfLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(shoLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(curSHO, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ceilSHO, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ceilingLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ceilSHO1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ceilingLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(curPLA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilPLA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilPLA1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(curSTK, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilSTK, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilSTK1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(curCHK, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilCHK, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilCHK1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(curPOS, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilPOS, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilPOS1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(curHIT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilHIT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilHIT1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(curSKA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilSKA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilSKA1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(curEND, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilEND, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilEND1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(curPEN, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilPEN, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilPEN1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(curFAC, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilFAC, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilFAC1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(curLEA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilLEA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilLEA1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(curFIG, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilFIG, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilFIG1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(curSTR, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ceilSTR, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ceilSTR1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projOF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projDF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projOA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(POT, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CON, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(GRD, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(INJ, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(curOF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(curDF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(curOA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(trainOF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ceilingLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(shoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(assistLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(gwgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(farmOF1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ceilingLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(weeklyLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wGP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wG, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(wGWG, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(trainDF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(farmDF1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addComponent(trainOA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(farmOA1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mGP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(weeklyLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mG, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mGWG, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(curStreakGP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(curStreakG, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(curStreakP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(weeklyLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(similarPlayerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bStreakGP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bStreakG, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bStreakA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bStreakP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bStreakGWG, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(weeklyLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(careerG, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(careerA, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(careerP, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(weeklyLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(55, 55, 55)
                        .addComponent(playerID))
                    .addGroup(playerPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(1266, 1266, 1266))
        );

        java.util.ResourceBundle bundle1 = java.util.ResourceBundle.getBundle("view/Bundle"); // NOI18N
        draftLabel.getAccessibleContext().setAccessibleName(bundle1.getString("GUI.draftLabel.AccessibleContext.accessibleName")); // NOI18N
        ceilingLabel.getAccessibleContext().setAccessibleName(bundle1.getString("GUI.jLabel3.AccessibleContext.accessibleName")); // NOI18N
        ceilSHO.getAccessibleContext().setAccessibleDescription(bundle1.getString("GUI.ceilSHO.AccessibleContext.accessibleDescription")); // NOI18N

        playerTab.addTab(bundle.getString("GUI.playerPanel.TabConstraints.tabTitle"), playerPanel); // NOI18N

        comparePlayerField1.setText(bundle.getString("GUI.comparePlayerField1.text")); // NOI18N
        comparePlayerField1.setToolTipText(bundle.getString("GUI.comparePlayerField1.toolTipText")); // NOI18N
        comparePlayerField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comparePlayerField1KeyPressed(evt);
            }
        });

        comparePlayerField2.setText(bundle.getString("GUI.comparePlayerField2.text")); // NOI18N
        comparePlayerField2.setToolTipText(bundle.getString("GUI.comparePlayerField2.toolTipText")); // NOI18N
        comparePlayerField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                comparePlayerField2KeyPressed(evt);
            }
        });

        comparePlayerButton.setText(bundle.getString("GUI.comparePlayerButton.text")); // NOI18N
        comparePlayerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comparePlayerButtonActionPerformed(evt);
            }
        });

        stkLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        stkLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stkLabel1.setText(bundle.getString("GUI.stkLabel1.text")); // NOI18N
        stkLabel1.setToolTipText(bundle.getString("GUI.stkLabel1.toolTipText")); // NOI18N
        stkLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        stkLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        stkLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        plaLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        plaLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        plaLabel1.setText(bundle.getString("GUI.plaLabel1.text")); // NOI18N
        plaLabel1.setToolTipText(bundle.getString("GUI.plaLabel1.toolTipText")); // NOI18N
        plaLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        plaLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        plaLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        skaLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        skaLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        skaLabel1.setText(bundle.getString("GUI.skaLabel1.text")); // NOI18N
        skaLabel1.setToolTipText(bundle.getString("GUI.skaLabel1.toolTipText")); // NOI18N
        skaLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        skaLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        skaLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        hitLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        hitLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hitLabel1.setText(bundle.getString("GUI.hitLabel1.text")); // NOI18N
        hitLabel1.setToolTipText(bundle.getString("GUI.hitLabel1.toolTipText")); // NOI18N
        hitLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        hitLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        hitLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        posLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        posLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        posLabel1.setText(bundle.getString("GUI.posLabel1.text")); // NOI18N
        posLabel1.setToolTipText(bundle.getString("GUI.posLabel1.toolTipText")); // NOI18N
        posLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        posLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        posLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        chkLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        chkLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        chkLabel1.setText(bundle.getString("GUI.chkLabel1.text")); // NOI18N
        chkLabel1.setToolTipText(bundle.getString("GUI.chkLabel1.toolTipText")); // NOI18N
        chkLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        chkLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        chkLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        projSTR1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projSTR1.setEditable(false);
        projSTR1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        projSTR1.setText(bundle.getString("GUI.projSTR1.text")); // NOI18N
        projSTR1.setToolTipText(bundle.getString("GUI.projSTR1.toolTipText")); // NOI18N
        projSTR1.setMaximumSize(new java.awt.Dimension(30, 25));
        projSTR1.setMinimumSize(new java.awt.Dimension(30, 25));
        projSTR1.setPreferredSize(new java.awt.Dimension(30, 25));

        projFIG1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projFIG1.setEditable(false);
        projFIG1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        projFIG1.setText(bundle.getString("GUI.projFIG1.text")); // NOI18N
        projFIG1.setToolTipText(bundle.getString("GUI.projFIG1.toolTipText")); // NOI18N
        projFIG1.setMaximumSize(new java.awt.Dimension(30, 25));
        projFIG1.setMinimumSize(new java.awt.Dimension(30, 25));
        projFIG1.setPreferredSize(new java.awt.Dimension(30, 25));

        projFAC1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projFAC1.setEditable(false);
        projFAC1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        projFAC1.setText(bundle.getString("GUI.projFAC1.text")); // NOI18N
        projFAC1.setToolTipText(bundle.getString("GUI.projFAC1.toolTipText")); // NOI18N
        projFAC1.setMaximumSize(new java.awt.Dimension(30, 25));
        projFAC1.setMinimumSize(new java.awt.Dimension(30, 25));
        projFAC1.setPreferredSize(new java.awt.Dimension(30, 25));

        projSKA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projSKA1.setEditable(false);
        projSKA1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        projSKA1.setText(bundle.getString("GUI.projSKA1.text")); // NOI18N
        projSKA1.setToolTipText(bundle.getString("GUI.projSKA1.toolTipText")); // NOI18N
        projSKA1.setMaximumSize(new java.awt.Dimension(30, 25));
        projSKA1.setMinimumSize(new java.awt.Dimension(30, 25));
        projSKA1.setPreferredSize(new java.awt.Dimension(30, 25));

        projHIT1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projHIT1.setEditable(false);
        projHIT1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        projHIT1.setText(bundle.getString("GUI.projHIT1.text")); // NOI18N
        projHIT1.setToolTipText(bundle.getString("GUI.projHIT1.toolTipText")); // NOI18N
        projHIT1.setMaximumSize(new java.awt.Dimension(30, 25));
        projHIT1.setMinimumSize(new java.awt.Dimension(30, 25));
        projHIT1.setPreferredSize(new java.awt.Dimension(30, 25));

        projSTK1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projSTK1.setEditable(false);
        projSTK1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        projSTK1.setText(bundle.getString("GUI.projSTK1.text")); // NOI18N
        projSTK1.setToolTipText(bundle.getString("GUI.projSTK1.toolTipText")); // NOI18N
        projSTK1.setMaximumSize(new java.awt.Dimension(30, 25));
        projSTK1.setMinimumSize(new java.awt.Dimension(30, 25));
        projSTK1.setPreferredSize(new java.awt.Dimension(30, 25));

        projPOS1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projPOS1.setEditable(false);
        projPOS1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        projPOS1.setText(bundle.getString("GUI.projPOS1.text")); // NOI18N
        projPOS1.setToolTipText(bundle.getString("GUI.projPOS1.toolTipText")); // NOI18N
        projPOS1.setMaximumSize(new java.awt.Dimension(30, 25));
        projPOS1.setMinimumSize(new java.awt.Dimension(30, 25));
        projPOS1.setPreferredSize(new java.awt.Dimension(30, 25));

        projCHK1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projCHK1.setEditable(false);
        projCHK1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        projCHK1.setText(bundle.getString("GUI.projCHK1.text")); // NOI18N
        projCHK1.setToolTipText(bundle.getString("GUI.projCHK1.toolTipText")); // NOI18N
        projCHK1.setMaximumSize(new java.awt.Dimension(30, 25));
        projCHK1.setMinimumSize(new java.awt.Dimension(30, 25));
        projCHK1.setPreferredSize(new java.awt.Dimension(30, 25));

        projPLA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projPLA1.setEditable(false);
        projPLA1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        projPLA1.setText(bundle.getString("GUI.projPLA1.text")); // NOI18N
        projPLA1.setToolTipText(bundle.getString("GUI.projPLA1.toolTipText")); // NOI18N
        projPLA1.setMaximumSize(new java.awt.Dimension(30, 25));
        projPLA1.setMinimumSize(new java.awt.Dimension(30, 25));
        projPLA1.setPreferredSize(new java.awt.Dimension(30, 25));

        projSHO1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projSHO1.setEditable(false);
        projSHO1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        projSHO1.setText(bundle.getString("GUI.projSHO1.text")); // NOI18N
        projSHO1.setToolTipText(bundle.getString("GUI.projSHO1.toolTipText")); // NOI18N
        projSHO1.setMaximumSize(new java.awt.Dimension(30, 25));
        projSHO1.setMinimumSize(new java.awt.Dimension(30, 25));
        projSHO1.setPreferredSize(new java.awt.Dimension(30, 25));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText(bundle.getString("GUI.jLabel10.text")); // NOI18N
        jLabel10.setToolTipText(bundle.getString("GUI.jLabel10.toolTipText")); // NOI18N
        jLabel10.setMaximumSize(new java.awt.Dimension(30, 25));
        jLabel10.setMinimumSize(new java.awt.Dimension(30, 25));

        projDF1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projDF1.setEditable(false);
        projDF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        projDF1.setText(bundle.getString("GUI.projDF1.text")); // NOI18N
        projDF1.setToolTipText(bundle.getString("GUI.projDF1.toolTipText")); // NOI18N
        projDF1.setMaximumSize(new java.awt.Dimension(30, 25));
        projDF1.setMinimumSize(new java.awt.Dimension(30, 25));
        projDF1.setPreferredSize(new java.awt.Dimension(30, 25));

        ceilingLabel4.setFont(new java.awt.Font("Tahoma", 1, 11));
        ceilingLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ceilingLabel4.setText(bundle.getString("GUI.ceilingLabel4.text")); // NOI18N
        ceilingLabel4.setToolTipText(bundle.getString("GUI.ceilingLabel4.toolTipText")); // NOI18N
        ceilingLabel4.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilingLabel4.setMinimumSize(new java.awt.Dimension(30, 25));

        projOF1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projOF1.setEditable(false);
        projOF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        projOF1.setText(bundle.getString("GUI.projOF1.text")); // NOI18N
        projOF1.setToolTipText(bundle.getString("GUI.projOF1.toolTipText")); // NOI18N
        projOF1.setMaximumSize(new java.awt.Dimension(30, 25));
        projOF1.setMinimumSize(new java.awt.Dimension(30, 25));
        projOF1.setPreferredSize(new java.awt.Dimension(30, 25));

        curLEA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curLEA1.setEditable(false);
        curLEA1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curLEA1.setText(bundle.getString("GUI.curLEA1.text")); // NOI18N
        curLEA1.setToolTipText(bundle.getString("GUI.curLEA1.toolTipText")); // NOI18N
        curLEA1.setMaximumSize(new java.awt.Dimension(30, 25));
        curLEA1.setMinimumSize(new java.awt.Dimension(30, 25));
        curLEA1.setPreferredSize(new java.awt.Dimension(30, 25));

        curFAC1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curFAC1.setEditable(false);
        curFAC1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curFAC1.setText(bundle.getString("GUI.curFAC1.text")); // NOI18N
        curFAC1.setToolTipText(bundle.getString("GUI.curFAC1.toolTipText")); // NOI18N
        curFAC1.setMaximumSize(new java.awt.Dimension(30, 25));
        curFAC1.setMinimumSize(new java.awt.Dimension(30, 25));
        curFAC1.setPreferredSize(new java.awt.Dimension(30, 25));

        shoLabel2.setFont(new java.awt.Font("Tahoma", 1, 12));
        shoLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        shoLabel2.setText(bundle.getString("GUI.shoLabel2.text")); // NOI18N
        shoLabel2.setToolTipText(bundle.getString("GUI.shoLabel2.toolTipText")); // NOI18N
        shoLabel2.setMaximumSize(new java.awt.Dimension(30, 25));
        shoLabel2.setMinimumSize(new java.awt.Dimension(30, 25));

        curSTR1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curSTR1.setEditable(false);
        curSTR1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curSTR1.setText(bundle.getString("GUI.curSTR1.text")); // NOI18N
        curSTR1.setToolTipText(bundle.getString("GUI.curSTR1.toolTipText")); // NOI18N
        curSTR1.setMaximumSize(new java.awt.Dimension(30, 25));
        curSTR1.setMinimumSize(new java.awt.Dimension(30, 25));
        curSTR1.setPreferredSize(new java.awt.Dimension(30, 25));

        curFIG1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curFIG1.setEditable(false);
        curFIG1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curFIG1.setText(bundle.getString("GUI.curFIG1.text")); // NOI18N
        curFIG1.setToolTipText(bundle.getString("GUI.curFIG1.toolTipText")); // NOI18N
        curFIG1.setMaximumSize(new java.awt.Dimension(30, 25));
        curFIG1.setMinimumSize(new java.awt.Dimension(30, 25));
        curFIG1.setPreferredSize(new java.awt.Dimension(30, 25));

        POT1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        POT1.setEditable(false);
        POT1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        POT1.setText(bundle.getString("GUI.POT1.text")); // NOI18N
        POT1.setToolTipText(bundle.getString("GUI.POT1.toolTipText")); // NOI18N
        POT1.setMaximumSize(new java.awt.Dimension(30, 25));
        POT1.setMinimumSize(new java.awt.Dimension(30, 25));
        POT1.setPreferredSize(new java.awt.Dimension(30, 25));

        CON1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CON1.setEditable(false);
        CON1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        CON1.setText(bundle.getString("GUI.CON1.text")); // NOI18N
        CON1.setToolTipText(bundle.getString("GUI.CON1.toolTipText")); // NOI18N
        CON1.setMaximumSize(new java.awt.Dimension(30, 25));
        CON1.setMinimumSize(new java.awt.Dimension(30, 25));
        CON1.setPreferredSize(new java.awt.Dimension(30, 25));

        GRD1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        GRD1.setEditable(false);
        GRD1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        GRD1.setText(bundle.getString("GUI.GRD1.text")); // NOI18N
        GRD1.setToolTipText(bundle.getString("GUI.GRD1.toolTipText")); // NOI18N
        GRD1.setMaximumSize(new java.awt.Dimension(30, 25));
        GRD1.setMinimumSize(new java.awt.Dimension(30, 25));
        GRD1.setPreferredSize(new java.awt.Dimension(30, 25));

        INJ1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        INJ1.setEditable(false);
        INJ1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        INJ1.setText(bundle.getString("GUI.INJ1.text")); // NOI18N
        INJ1.setToolTipText(bundle.getString("GUI.INJ1.toolTipText")); // NOI18N
        INJ1.setMaximumSize(new java.awt.Dimension(30, 25));
        INJ1.setMinimumSize(new java.awt.Dimension(30, 25));
        INJ1.setPreferredSize(new java.awt.Dimension(30, 25));

        curOF1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curOF1.setEditable(false);
        curOF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curOF1.setText(bundle.getString("GUI.curOF1.text")); // NOI18N
        curOF1.setToolTipText(bundle.getString("GUI.curOF1.toolTipText")); // NOI18N
        curOF1.setMaximumSize(new java.awt.Dimension(30, 25));
        curOF1.setMinimumSize(new java.awt.Dimension(30, 25));
        curOF1.setPreferredSize(new java.awt.Dimension(30, 25));

        curDF1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curDF1.setEditable(false);
        curDF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curDF1.setText(bundle.getString("GUI.curDF1.text")); // NOI18N
        curDF1.setToolTipText(bundle.getString("GUI.curDF1.toolTipText")); // NOI18N
        curDF1.setMaximumSize(new java.awt.Dimension(30, 25));
        curDF1.setMinimumSize(new java.awt.Dimension(30, 25));
        curDF1.setPreferredSize(new java.awt.Dimension(30, 25));

        curOA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curOA1.setEditable(false);
        curOA1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curOA1.setText(bundle.getString("GUI.curOA1.text")); // NOI18N
        curOA1.setToolTipText(bundle.getString("GUI.curOA1.toolTipText")); // NOI18N
        curOA1.setMaximumSize(new java.awt.Dimension(30, 25));
        curOA1.setMinimumSize(new java.awt.Dimension(30, 25));
        curOA1.setPreferredSize(new java.awt.Dimension(30, 25));
        curOA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                curOA1ActionPerformed(evt);
            }
        });

        curSTK1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curSTK1.setEditable(false);
        curSTK1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curSTK1.setText(bundle.getString("GUI.curSTK1.text")); // NOI18N
        curSTK1.setToolTipText(bundle.getString("GUI.curSTK1.toolTipText")); // NOI18N
        curSTK1.setMaximumSize(new java.awt.Dimension(30, 25));
        curSTK1.setMinimumSize(new java.awt.Dimension(30, 25));
        curSTK1.setPreferredSize(new java.awt.Dimension(30, 25));

        curPLA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curPLA1.setEditable(false);
        curPLA1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curPLA1.setText(bundle.getString("GUI.curPLA1.text")); // NOI18N
        curPLA1.setToolTipText(bundle.getString("GUI.curPLA1.toolTipText")); // NOI18N
        curPLA1.setMaximumSize(new java.awt.Dimension(30, 25));
        curPLA1.setMinimumSize(new java.awt.Dimension(30, 25));
        curPLA1.setPreferredSize(new java.awt.Dimension(30, 25));

        curSHO1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curSHO1.setEditable(false);
        curSHO1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curSHO1.setText(bundle.getString("GUI.curSHO1.text")); // NOI18N
        curSHO1.setToolTipText(bundle.getString("GUI.curSHO1.toolTipText")); // NOI18N
        curSHO1.setMaximumSize(new java.awt.Dimension(30, 25));
        curSHO1.setMinimumSize(new java.awt.Dimension(30, 25));
        curSHO1.setPreferredSize(new java.awt.Dimension(30, 25));

        oaLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        oaLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        oaLabel1.setText(bundle.getString("GUI.oaLabel1.text")); // NOI18N
        oaLabel1.setToolTipText(bundle.getString("GUI.oaLabel1.toolTipText")); // NOI18N
        oaLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        oaLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        oaLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        dfLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        dfLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dfLabel1.setText(bundle.getString("GUI.dfLabel1.text")); // NOI18N
        dfLabel1.setToolTipText(bundle.getString("GUI.dfLabel1.toolTipText")); // NOI18N
        dfLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        dfLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        dfLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        curEND1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curEND1.setEditable(false);
        curEND1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curEND1.setText(bundle.getString("GUI.curEND1.text")); // NOI18N
        curEND1.setToolTipText(bundle.getString("GUI.curEND1.toolTipText")); // NOI18N
        curEND1.setMaximumSize(new java.awt.Dimension(30, 25));
        curEND1.setMinimumSize(new java.awt.Dimension(30, 25));
        curEND1.setPreferredSize(new java.awt.Dimension(30, 25));

        curPEN1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curPEN1.setEditable(false);
        curPEN1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curPEN1.setText(bundle.getString("GUI.curPEN1.text")); // NOI18N
        curPEN1.setToolTipText(bundle.getString("GUI.curPEN1.toolTipText")); // NOI18N
        curPEN1.setMaximumSize(new java.awt.Dimension(30, 25));
        curPEN1.setMinimumSize(new java.awt.Dimension(30, 25));
        curPEN1.setPreferredSize(new java.awt.Dimension(30, 25));

        curHIT1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curHIT1.setEditable(false);
        curHIT1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curHIT1.setText(bundle.getString("GUI.curHIT1.text")); // NOI18N
        curHIT1.setToolTipText(bundle.getString("GUI.curHIT1.toolTipText")); // NOI18N
        curHIT1.setMaximumSize(new java.awt.Dimension(30, 25));
        curHIT1.setMinimumSize(new java.awt.Dimension(30, 25));
        curHIT1.setPreferredSize(new java.awt.Dimension(30, 25));

        curSKA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curSKA1.setEditable(false);
        curSKA1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curSKA1.setText(bundle.getString("GUI.curSKA1.text")); // NOI18N
        curSKA1.setToolTipText(bundle.getString("GUI.curSKA1.toolTipText")); // NOI18N
        curSKA1.setMaximumSize(new java.awt.Dimension(30, 25));
        curSKA1.setMinimumSize(new java.awt.Dimension(30, 25));
        curSKA1.setPreferredSize(new java.awt.Dimension(30, 25));

        curCHK1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curCHK1.setEditable(false);
        curCHK1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curCHK1.setText(bundle.getString("GUI.curCHK1.text")); // NOI18N
        curCHK1.setToolTipText(bundle.getString("GUI.curCHK1.toolTipText")); // NOI18N
        curCHK1.setMaximumSize(new java.awt.Dimension(30, 25));
        curCHK1.setMinimumSize(new java.awt.Dimension(30, 25));
        curCHK1.setPreferredSize(new java.awt.Dimension(30, 25));

        curPOS1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        curPOS1.setEditable(false);
        curPOS1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        curPOS1.setText(bundle.getString("GUI.curPOS1.text")); // NOI18N
        curPOS1.setToolTipText(bundle.getString("GUI.curPOS1.toolTipText")); // NOI18N
        curPOS1.setMaximumSize(new java.awt.Dimension(30, 25));
        curPOS1.setMinimumSize(new java.awt.Dimension(30, 25));
        curPOS1.setPreferredSize(new java.awt.Dimension(30, 25));

        strLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        strLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        strLabel1.setText(bundle.getString("GUI.strLabel1.text")); // NOI18N
        strLabel1.setToolTipText(bundle.getString("GUI.strLabel1.toolTipText")); // NOI18N
        strLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        strLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        strLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        figLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        figLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        figLabel1.setText(bundle.getString("GUI.figLabel1.text")); // NOI18N
        figLabel1.setToolTipText(bundle.getString("GUI.figLabel1.toolTipText")); // NOI18N
        figLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        figLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        figLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        penLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        penLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        penLabel1.setText(bundle.getString("GUI.penLabel1.text")); // NOI18N
        penLabel1.setToolTipText(bundle.getString("GUI.penLabel1.toolTipText")); // NOI18N
        penLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        penLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        penLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        endLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        endLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        endLabel1.setText(bundle.getString("GUI.endLabel1.text")); // NOI18N
        endLabel1.setToolTipText(bundle.getString("GUI.endLabel1.toolTipText")); // NOI18N
        endLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        endLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        endLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        leaLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        leaLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        leaLabel1.setText(bundle.getString("GUI.leaLabel1.text")); // NOI18N
        leaLabel1.setToolTipText(bundle.getString("GUI.leaLabel1.toolTipText")); // NOI18N
        leaLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        leaLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        leaLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        facLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        facLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        facLabel1.setText(bundle.getString("GUI.facLabel1.text")); // NOI18N
        facLabel1.setToolTipText(bundle.getString("GUI.facLabel1.toolTipText")); // NOI18N
        facLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        facLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        facLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        conLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        conLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        conLabel1.setText(bundle.getString("GUI.conLabel1.text")); // NOI18N
        conLabel1.setToolTipText(bundle.getString("GUI.conLabel1.toolTipText")); // NOI18N
        conLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        conLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        conLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        grdLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        grdLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        grdLabel1.setText(bundle.getString("GUI.grdLabel1.text")); // NOI18N
        grdLabel1.setToolTipText(bundle.getString("GUI.grdLabel1.toolTipText")); // NOI18N
        grdLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        grdLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        grdLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        injLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        injLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        injLabel1.setText(bundle.getString("GUI.injLabel1.text")); // NOI18N
        injLabel1.setToolTipText(bundle.getString("GUI.injLabel1.toolTipText")); // NOI18N
        injLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        injLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        injLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        ofLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        ofLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ofLabel1.setText(bundle.getString("GUI.ofLabel1.text")); // NOI18N
        ofLabel1.setToolTipText(bundle.getString("GUI.ofLabel1.toolTipText")); // NOI18N
        ofLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ofLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        ofLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        potLabel1.setFont(new java.awt.Font("Tahoma", 1, 12));
        potLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        potLabel1.setText(bundle.getString("GUI.potLabel1.text")); // NOI18N
        potLabel1.setToolTipText(bundle.getString("GUI.potLabel1.toolTipText")); // NOI18N
        potLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        potLabel1.setMaximumSize(new java.awt.Dimension(30, 25));
        potLabel1.setMinimumSize(new java.awt.Dimension(30, 25));

        projOA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        projOA1.setEditable(false);
        projOA1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        projOA1.setText(bundle.getString("GUI.projOA1.text")); // NOI18N
        projOA1.setToolTipText(bundle.getString("GUI.projOA1.toolTipText")); // NOI18N
        projOA1.setMaximumSize(new java.awt.Dimension(30, 25));
        projOA1.setMinimumSize(new java.awt.Dimension(30, 25));
        projOA1.setPreferredSize(new java.awt.Dimension(30, 25));

        salaryYrLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        salaryYrLabel1.setText(bundle.getString("GUI.salaryYrLabel1.text")); // NOI18N
        salaryYrLabel1.setToolTipText(bundle.getString("GUI.salaryYrLabel1.toolTipText")); // NOI18N
        salaryYrLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        salaryAmt1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        salaryAmt1.setEditable(false);
        salaryAmt1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salaryAmt1.setText(bundle.getString("GUI.salaryAmt1.text")); // NOI18N
        salaryAmt1.setMaximumSize(new java.awt.Dimension(61, 25));
        salaryAmt1.setMinimumSize(new java.awt.Dimension(25, 25));

        salaryYr1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        salaryYr1.setEditable(false);
        salaryYr1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        salaryYr1.setText(bundle.getString("GUI.salaryYr1.text")); // NOI18N
        salaryYr1.setToolTipText(bundle.getString("GUI.salaryYr1.toolTipText")); // NOI18N
        salaryYr1.setMaximumSize(new java.awt.Dimension(25, 25));
        salaryYr1.setMinimumSize(new java.awt.Dimension(25, 25));
        salaryYr1.setPreferredSize(new java.awt.Dimension(25, 25));

        salaryAmtLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        salaryAmtLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salaryAmtLabel1.setLabelFor(salaryAmt);
        salaryAmtLabel1.setText(bundle.getString("GUI.salaryAmtLabel1.text")); // NOI18N
        salaryAmtLabel1.setToolTipText(bundle.getString("GUI.salaryAmtLabel1.toolTipText")); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setLabelFor(salaryAmtLabel);
        jLabel11.setText(bundle.getString("GUI.jLabel11.text")); // NOI18N
        jLabel11.setToolTipText(bundle.getString("GUI.jLabel11.toolTipText")); // NOI18N

        trainOA1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        trainOA1.setEditable(false);
        trainOA1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        trainOA1.setText(bundle.getString("GUI.trainOA1.text")); // NOI18N
        trainOA1.setToolTipText(bundle.getString("GUI.trainOA1.toolTipText")); // NOI18N
        trainOA1.setMaximumSize(new java.awt.Dimension(30, 25));
        trainOA1.setMinimumSize(new java.awt.Dimension(30, 25));
        trainOA1.setPreferredSize(new java.awt.Dimension(30, 25));
        trainOA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainOA1ActionPerformed(evt);
            }
        });

        ceilingLabel5.setFont(new java.awt.Font("Tahoma", 1, 11));
        ceilingLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ceilingLabel5.setText(bundle.getString("GUI.ceilingLabel5.text")); // NOI18N
        ceilingLabel5.setToolTipText(bundle.getString("GUI.ceilingLabel5.toolTipText")); // NOI18N
        ceilingLabel5.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilingLabel5.setMinimumSize(new java.awt.Dimension(30, 25));

        trainOF1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        trainOF1.setEditable(false);
        trainOF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        trainOF1.setText(bundle.getString("GUI.trainOF1.text")); // NOI18N
        trainOF1.setToolTipText(bundle.getString("GUI.trainOF1.toolTipText")); // NOI18N
        trainOF1.setMaximumSize(new java.awt.Dimension(30, 25));
        trainOF1.setMinimumSize(new java.awt.Dimension(30, 25));
        trainOF1.setPreferredSize(new java.awt.Dimension(30, 25));

        trainDF1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        trainDF1.setEditable(false);
        trainDF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        trainDF1.setText(bundle.getString("GUI.trainDF1.text")); // NOI18N
        trainDF1.setToolTipText(bundle.getString("GUI.trainDF1.toolTipText")); // NOI18N
        trainDF1.setMaximumSize(new java.awt.Dimension(30, 25));
        trainDF1.setMinimumSize(new java.awt.Dimension(30, 25));
        trainDF1.setPreferredSize(new java.awt.Dimension(30, 25));

        farmOF2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        farmOF2.setEditable(false);
        farmOF2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        farmOF2.setText(bundle.getString("GUI.farmOF2.text")); // NOI18N
        farmOF2.setToolTipText(bundle.getString("GUI.farmOF2.toolTipText")); // NOI18N
        farmOF2.setMaximumSize(new java.awt.Dimension(30, 25));
        farmOF2.setMinimumSize(new java.awt.Dimension(30, 25));
        farmOF2.setPreferredSize(new java.awt.Dimension(30, 25));

        farmDF2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        farmDF2.setEditable(false);
        farmDF2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        farmDF2.setText(bundle.getString("GUI.farmDF2.text")); // NOI18N
        farmDF2.setToolTipText(bundle.getString("GUI.farmDF2.toolTipText")); // NOI18N
        farmDF2.setMaximumSize(new java.awt.Dimension(30, 25));
        farmDF2.setMinimumSize(new java.awt.Dimension(30, 25));
        farmDF2.setPreferredSize(new java.awt.Dimension(30, 25));

        ceilingLabel6.setFont(new java.awt.Font("Tahoma", 1, 11));
        ceilingLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ceilingLabel6.setText(bundle.getString("GUI.ceilingLabel6.text")); // NOI18N
        ceilingLabel6.setToolTipText(bundle.getString("GUI.ceilingLabel6.toolTipText")); // NOI18N
        ceilingLabel6.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilingLabel6.setMinimumSize(new java.awt.Dimension(30, 25));

        farmOA2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        farmOA2.setEditable(false);
        farmOA2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        farmOA2.setText(bundle.getString("GUI.farmOA2.text")); // NOI18N
        farmOA2.setToolTipText(bundle.getString("GUI.farmOA2.toolTipText")); // NOI18N
        farmOA2.setMaximumSize(new java.awt.Dimension(30, 25));
        farmOA2.setMinimumSize(new java.awt.Dimension(30, 25));
        farmOA2.setPreferredSize(new java.awt.Dimension(30, 25));
        farmOA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                farmOA2ActionPerformed(evt);
            }
        });

        ceilingLabel7.setFont(new java.awt.Font("Tahoma", 1, 11));
        ceilingLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ceilingLabel7.setText(bundle.getString("GUI.ceilingLabel7.text")); // NOI18N
        ceilingLabel7.setToolTipText(bundle.getString("GUI.ceilingLabel7.toolTipText")); // NOI18N
        ceilingLabel7.setMaximumSize(new java.awt.Dimension(30, 25));
        ceilingLabel7.setMinimumSize(new java.awt.Dimension(30, 25));

        compareResult.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        compareResult.setEditable(false);
        compareResult.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        compareResult.setText(bundle.getString("GUI.compareResult.text")); // NOI18N
        compareResult.setToolTipText(bundle.getString("GUI.compareResult.toolTipText")); // NOI18N
        compareResult.setMaximumSize(new java.awt.Dimension(30, 25));
        compareResult.setMinimumSize(new java.awt.Dimension(30, 25));
        compareResult.setPreferredSize(new java.awt.Dimension(30, 25));

        ageLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        ageLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ageLabel1.setLabelFor(age);
        ageLabel1.setText(bundle.getString("GUI.ageLabel1.text")); // NOI18N
        ageLabel1.setToolTipText(bundle.getString("GUI.ageLabel1.toolTipText")); // NOI18N

        age1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        age1.setEditable(false);
        age1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        age1.setText(bundle.getString("GUI.age1.text")); // NOI18N
        age1.setToolTipText(bundle.getString("GUI.age1.toolTipText")); // NOI18N
        age1.setMaximumSize(new java.awt.Dimension(35, 25));
        age1.setMinimumSize(new java.awt.Dimension(35, 25));

        playerTypeC1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        playerTypeC1.setEditable(false);
        playerTypeC1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        playerTypeC1.setText(bundle.getString("GUI.playerTypeC1.text")); // NOI18N
        playerTypeC1.setToolTipText(bundle.getString("GUI.playerTypeC1.toolTipText")); // NOI18N
        playerTypeC1.setMaximumSize(new java.awt.Dimension(35, 25));
        playerTypeC1.setMinimumSize(new java.awt.Dimension(35, 25));

        playerTypeC2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        playerTypeC2.setEditable(false);
        playerTypeC2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        playerTypeC2.setText(bundle.getString("GUI.playerTypeC2.text")); // NOI18N
        playerTypeC2.setToolTipText(bundle.getString("GUI.playerTypeC1.toolTipText")); // NOI18N
        playerTypeC2.setMaximumSize(new java.awt.Dimension(35, 25));
        playerTypeC2.setMinimumSize(new java.awt.Dimension(35, 25));

        playerTypeC3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        playerTypeC3.setEditable(false);
        playerTypeC3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        playerTypeC3.setText(bundle.getString("GUI.playerTypeC3.text")); // NOI18N
        playerTypeC3.setToolTipText(bundle.getString("GUI.playerTypeC3.toolTipText")); // NOI18N
        playerTypeC3.setMaximumSize(new java.awt.Dimension(35, 25));
        playerTypeC3.setMinimumSize(new java.awt.Dimension(35, 25));

        playerTypeC4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        playerTypeC4.setEditable(false);
        playerTypeC4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        playerTypeC4.setText(bundle.getString("GUI.playerTypeC4.text")); // NOI18N
        playerTypeC4.setToolTipText(bundle.getString("GUI.playerTypeC3.toolTipText")); // NOI18N
        playerTypeC4.setMaximumSize(new java.awt.Dimension(35, 25));
        playerTypeC4.setMinimumSize(new java.awt.Dimension(35, 25));

        posiC1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        posiC1.setEditable(false);
        posiC1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        posiC1.setText(bundle.getString("GUI.posiC1.text")); // NOI18N
        posiC1.setToolTipText(bundle.getString("GUI.posiC3.toolTipText")); // NOI18N
        posiC1.setMaximumSize(new java.awt.Dimension(25, 25));
        posiC1.setMinimumSize(new java.awt.Dimension(25, 25));
        posiC1.setPreferredSize(new java.awt.Dimension(25, 25));

        posiC2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        posiC2.setEditable(false);
        posiC2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        posiC2.setText(bundle.getString("GUI.posiC2.text")); // NOI18N
        posiC2.setToolTipText(bundle.getString("GUI.posiC2.toolTipText")); // NOI18N
        posiC2.setMaximumSize(new java.awt.Dimension(25, 25));
        posiC2.setMinimumSize(new java.awt.Dimension(25, 25));
        posiC2.setPreferredSize(new java.awt.Dimension(25, 25));

        posiC3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        posiC3.setEditable(false);
        posiC3.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        posiC3.setText(bundle.getString("GUI.posiC3.text")); // NOI18N
        posiC3.setToolTipText(bundle.getString("GUI.posiC3.toolTipText")); // NOI18N
        posiC3.setMaximumSize(new java.awt.Dimension(25, 25));
        posiC3.setMinimumSize(new java.awt.Dimension(25, 25));
        posiC3.setPreferredSize(new java.awt.Dimension(25, 25));

        posiC4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        posiC4.setEditable(false);
        posiC4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        posiC4.setText(bundle.getString("GUI.posiC4.text")); // NOI18N
        posiC4.setToolTipText(bundle.getString("GUI.posiC2.toolTipText")); // NOI18N
        posiC4.setMaximumSize(new java.awt.Dimension(25, 25));
        posiC4.setMinimumSize(new java.awt.Dimension(25, 25));
        posiC4.setPreferredSize(new java.awt.Dimension(25, 25));

        javax.swing.GroupLayout comparePlayersTabLayout = new javax.swing.GroupLayout(comparePlayersTab);
        comparePlayersTab.setLayout(comparePlayersTabLayout);
        comparePlayersTabLayout.setHorizontalGroup(
            comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comparePlayersTabLayout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(posiC1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(posiC2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 487, Short.MAX_VALUE)
                .addComponent(posiC3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(posiC4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
            .addGroup(comparePlayersTabLayout.createSequentialGroup()
                .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(comparePlayersTabLayout.createSequentialGroup()
                        .addGap(403, 403, 403)
                        .addComponent(comparePlayerField1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comparePlayerButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comparePlayerField2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(comparePlayersTabLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(shoLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(ceilingLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(curSHO1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(projSHO1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                .addComponent(curPLA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(curSTK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                .addComponent(plaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(stkLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                .addComponent(chkLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(posLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(hitLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(skaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(endLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(penLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(facLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(leaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(figLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(strLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(potLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(conLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(grdLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(injLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ofLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(dfLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(oaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                    .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(projCHK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                            .addGap(36, 36, 36)
                                                            .addComponent(projPOS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                            .addGap(72, 72, 72)
                                                            .addComponent(projHIT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                            .addGap(216, 216, 216)
                                                            .addComponent(projFAC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                            .addGap(288, 288, 288)
                                                            .addComponent(projFIG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                            .addGap(324, 324, 324)
                                                            .addComponent(projSTR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                            .addGap(108, 108, 108)
                                                            .addComponent(projSKA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGap(100, 100, 100)
                                                    .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                            .addComponent(ceilingLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(farmOF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                                    .addGap(72, 72, 72)
                                                                    .addComponent(farmOA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                                    .addGap(36, 36, 36)
                                                                    .addComponent(farmDF2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                                .addComponent(ceilingLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(trainOF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(trainDF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(trainOA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                                .addComponent(projOF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(projDF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(projOA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                                .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                    .addComponent(curCHK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(curPOS1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(curHIT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(curSKA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(curEND1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(curPEN1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(curFAC1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(curLEA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(curFIG1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(curSTR1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(POT1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(CON1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(GRD1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(INJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(curOF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(curDF1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(curOA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(156, 156, 156)
                                                .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(playerTypeC1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(playerTypeC2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(playerTypeC3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(playerTypeC4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(57, 57, 57))))
                                    .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(projPLA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(projSTK1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(114, 114, 114)
                                        .addComponent(ceilingLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(compareResult, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                .addGap(166, 166, 166)
                                .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                        .addComponent(salaryYr1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(salaryAmt1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                        .addComponent(salaryYrLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(salaryAmtLabel1)))
                                .addGap(18, 18, 18)
                                .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(comparePlayersTabLayout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(ageLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(age1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(127, Short.MAX_VALUE))
        );
        comparePlayersTabLayout.setVerticalGroup(
            comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(comparePlayersTabLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comparePlayerField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comparePlayerButton)
                    .addComponent(comparePlayerField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, comparePlayersTabLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(posiC1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(posiC2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(posiC3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(posiC4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salaryAmtLabel1)
                            .addComponent(salaryYrLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(salaryYr1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(salaryAmt1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(comparePlayersTabLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(playerTypeC3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(playerTypeC1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ageLabel1)
                            .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(playerTypeC4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(playerTypeC2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(age1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(13, 13, 13)
                .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(comparePlayersTabLayout.createSequentialGroup()
                        .addComponent(shoLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(curSHO1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(comparePlayersTabLayout.createSequentialGroup()
                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(plaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(chkLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(posLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hitLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(skaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(penLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(facLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(leaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(stkLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(figLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(strLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(potLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(conLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(grdLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(injLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ofLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dfLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(oaLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(POT1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CON1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(GRD1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(INJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(curOF1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(curDF1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(curOA1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(curCHK1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(curPOS1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(curHIT1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(curSKA1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(curEND1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(curPEN1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(curFAC1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(curLEA1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(curFIG1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(curSTR1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(curPLA1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(curSTK1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(6, 6, 6)
                .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(comparePlayersTabLayout.createSequentialGroup()
                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(projPLA1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(projSHO1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ceilingLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(projSTK1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projCHK1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projPOS1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projHIT1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projSKA1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projFAC1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projFIG1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projSTR1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(compareResult, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ceilingLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(comparePlayersTabLayout.createSequentialGroup()
                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(projOF1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projDF1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(projOA1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(trainOF1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ceilingLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(trainDF1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(trainOA1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(comparePlayersTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(farmOF2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ceilingLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(farmDF2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(farmOA2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(190, Short.MAX_VALUE))
        );

        playerTab.addTab(bundle.getString("GUI.comparePlayersTab.TabConstraints.tabTitle"), comparePlayersTab); // NOI18N

        jMenu1.setText(bundle.getString("GUI.jMenu1.text")); // NOI18N

        openMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        openMenu.setText(bundle.getString("GUI.openMenu.text")); // NOI18N
        openMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuActionPerformed(evt);
            }
        });
        jMenu1.add(openMenu);

        writePlayersFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        writePlayersFile.setText(bundle.getString("GUI.writePlayersFile.text")); // NOI18N
        writePlayersFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                writePlayersFileActionPerformed(evt);
            }
        });
        jMenu1.add(writePlayersFile);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem2.setText(bundle.getString("GUI.jMenuItem2.text")); // NOI18N
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText(bundle.getString("GUI.jMenu2.text")); // NOI18N

        faq.setText(bundle.getString("GUI.faq.text")); // NOI18N
        faq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                faqActionPerformed(evt);
            }
        });
        jMenu2.add(faq);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(playerTab, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(playerTab, javax.swing.GroupLayout.PREFERRED_SIZE, 567, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        playerTab.getAccessibleContext().setAccessibleName(bundle1.getString("GUI.jTabbedPane1.AccessibleContext.accessibleName")); // NOI18N

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void openMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuActionPerformed
            final JFileChooser fc = new JFileChooser();
            fc.showOpenDialog(this);
            fH = new FileHandler(fc.getSelectedFile());
            this.initializeNewFile();
	}//GEN-LAST:event_openMenuActionPerformed

	private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
            // TODO add your handling code here:
	}//GEN-LAST:event_searchFieldActionPerformed

	private void curOAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curOAActionPerformed
            // TODO add your handling code here:
	}//GEN-LAST:event_curOAActionPerformed

	private void projOAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projOAActionPerformed
            // TODO add your handling code here:
	}//GEN-LAST:event_projOAActionPerformed

	private void trainOAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainOAActionPerformed
            // TODO add your handling code here:
	}//GEN-LAST:event_trainOAActionPerformed

	private void farmOA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_farmOA1ActionPerformed
            // TODO add your handling code here:
	}//GEN-LAST:event_farmOA1ActionPerformed

	private void searchPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchPlayerActionPerformed
            String player = searchField.getText().toLowerCase();
            Player old = foundPlayer;
            System.out.println(playerSet.size());
            for (Player p : playerSet) {
                if (p.getFullName().toLowerCase().contains(player)) {
                    foundPlayer = p;
                    searchField.setText(p.getFullName());
                }
            }
            if (foundPlayer == old || foundPlayer == null) {
                if (player.contains("o")) {
                    player.replace("o", "ö");
                    searchField.setText(player);
                    // searchPlayer.doClick();
                }
                //JOptionPane.showMessageDialog(this,"Unable to find player. Try typing the player's full name. Make sure you use correct symbols. Error is also thrown if you are on the same player","Unable to find Player", 1);
            } else {
                updateGUIToPlayer();
            }
	}//GEN-LAST:event_searchPlayerActionPerformed

	private void similarPlayerListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_similarPlayerListValueChanged
            try {
                searchField.setText(similarPlayerList.getSelectedValue().toString());
                searchPlayer.doClick();
            } catch (Throwable t) {
                t.printStackTrace();
            }
	}//GEN-LAST:event_similarPlayerListValueChanged

	private void searchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyPressed
            if (evt.getKeyCode() == 10) {
                searchPlayer.doClick();
            }
	}//GEN-LAST:event_searchFieldKeyPressed

        private void numPlayersProspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numPlayersProspActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_numPlayersProspActionPerformed

        private void numPlayersFarmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numPlayersFarmActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_numPlayersFarmActionPerformed

        private void numPlayersProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numPlayersProActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_numPlayersProActionPerformed

        private void proOAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proOAActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_proOAActionPerformed

        private void proDefenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proDefenseActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_proDefenseActionPerformed

        private void proOffenseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proOffenseActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_proOffenseActionPerformed

        private void numPlayersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numPlayersActionPerformed
            // TODO add your handling code here:
}//GEN-LAST:event_numPlayersActionPerformed

        private void teamSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamSearchButtonActionPerformed
            updateGUIToTeam();
}//GEN-LAST:event_teamSearchButtonActionPerformed

        private void teamSearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teamSearchFieldActionPerformed
}//GEN-LAST:event_teamSearchFieldActionPerformed

        private void proListLabelPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_proListLabelPropertyChange
            // TODO add your handling code here:
        }//GEN-LAST:event_proListLabelPropertyChange

        private void proTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_proTeamButtonActionPerformed
            updateGUIToTeam();

        }//GEN-LAST:event_proTeamButtonActionPerformed

        private void farmTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_farmTeamButtonActionPerformed
            updateGUIToTeam();
        }//GEN-LAST:event_farmTeamButtonActionPerformed

        private void prospectsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prospectsButtonActionPerformed
            updateGUIToTeam();
        }//GEN-LAST:event_prospectsButtonActionPerformed

        private void allButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allButtonActionPerformed
            updateGUIToTeam();
        }//GEN-LAST:event_allButtonActionPerformed

        private void createLinesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createLinesButtonActionPerformed
            String fileName = JOptionPane.showInputDialog("Enter desired file name");
            System.out.println(fileName);
            fileName.replaceAll("[.,;:!@#$%^* ]", "");
            if (fileName.equalsIgnoreCase("players") || fileName.equalsIgnoreCase("league")) {
                JOptionPane.showMessageDialog(this, "Bad file name choice");
            } else {
                ArrayList<String> id = new ArrayList<String>();
                String startingG = getPlayerId(gStarting.getText());
                id.add(startingG);
                id.add(getPlayerId(gBackup.getText()));
                id.add(getPlayerId(dpair1L.getText()));
                id.add(getPlayerId(dpair2L.getText()));
                id.add(getPlayerId(dpair3L.getText()));
                id.add(getPlayerId(dpair1R.getText()));
                id.add(getPlayerId(dPair2R.getText()));
                id.add(getPlayerId(dpair3R.getText()));
                id.add(getPlayerId(lwLine1.getText()));
                id.add(getPlayerId(lwLine2.getText()));
                id.add(getPlayerId(lwLine3.getText()));
                id.add(getPlayerId(lwLine4.getText()));
                id.add(getPlayerId(cLine1.getText()));
                id.add(getPlayerId(cLine2.getText()));
                id.add(getPlayerId(cLine3.getText()));
                id.add(getPlayerId(cLine4.getText()));
                id.add(getPlayerId(rwLine1.getText()));
                id.add(getPlayerId(rwLine2.getText()));
                id.add(getPlayerId(rwLine3.getText()));
                id.add(getPlayerId(rwLine4.getText()));
                id.add(getPlayerId(dpairLPP1.getText()));
                id.add(getPlayerId(dpairRPP1.getText()));
                id.add(getPlayerId(lwLinePP1.getText()));
                id.add(getPlayerId(cLinePP1.getText()));
                id.add(getPlayerId(rwLinePP1.getText()));
                id.add(getPlayerId(dpairLPP2.getText()));
                id.add(getPlayerId(dPairRPP2.getText()));
                id.add(getPlayerId(lwLinePP2.getText()));
                id.add(getPlayerId(cLinePP2.getText()));
                id.add(getPlayerId(rwLinePP2.getText()));
                id.add(getPlayerId(dpairLPK1.getText()));
                id.add(getPlayerId(dPairRPK1.getText()));
                id.add(getPlayerId(lwPK1.getText()));
                id.add(getPlayerId(rwPK1.getText()));
                id.add(startingG);
                id.add(getPlayerId(dpairLPK2.getText()));
                id.add(getPlayerId(dPairRPK2.getText()));
                id.add(getPlayerId(lwPK2.getText()));
                id.add(getPlayerId(rwPK2.getText()));
                id.add(startingG);
                String tactics1 = "" + TacticsLine1.getSelectedIndex() + " " + TacticsLine2.getSelectedIndex() + " " + TacticsLine3.getSelectedIndex() + " " + TacticsLine4.getSelectedIndex()
                        + " " + TacticsPP1.getSelectedIndex() + " " + TacticsPP2.getSelectedIndex() + " " + TacticsPK1.getSelectedIndex() + " " + TacticsPK2.getSelectedIndex();
                id.add(tactics1);
                String time = "" + Integer.parseInt(timeLine1.getText()) / 10 + " " + Integer.parseInt(timeLine2.getText()) / 10 + " " + Integer.parseInt(timeLine3.getText()) / 10 + " " + Integer.parseInt(timeLine4.getText()) / 10
                        + " " + Integer.parseInt(timePP1.getText()) / 10 + " " + Integer.parseInt(timePP2.getText()) / 10 + " " + Integer.parseInt(timePK1.getText()) / 10 + " " + Integer.parseInt(timePK2.getText()) / 10;
                id.add(time);
                fH.writeLinesFile(id, fileName);
            }


        }//GEN-LAST:event_createLinesButtonActionPerformed

        private void draftYearListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_draftYearListActionPerformed
            String yr = (String) draftYearList.getSelectedItem();
            Team draft = teamList.get(30);
            from=new DefaultListModel();
            draftBestAvailable.setModel(from);
            if (yr.equalsIgnoreCase("2017")) {//need to detect what current draft year is
                updateGUIToDraft(draft.getTop150(), draft);
                for(int i=draft.getTop150().size()-1;i>-1;i--){
                    Player p=draft.getTop150().get(i);
                    from.add(0, ""+p.getStringPosition()+"/"+p.getStringAlternatePosition()+" "+p.getFullName()+" "+p.getCON());
                }
            } else {
                updateGUIToDraft(league.getDrafts().get(yr), draft);
            }
        }//GEN-LAST:event_draftYearListActionPerformed

        private void draftYearListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_draftYearListMouseClicked
            //   draftYearList.removeAllItems();
            // for (String s: league.getDrafts().keySet()){
            //    draftYearList.addItem(s);
            //}
            //draftYearList.addItem("2017");
        }//GEN-LAST:event_draftYearListMouseClicked

        private void teamSearchFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_teamSearchFieldKeyPressed
            if (evt.getKeyCode() == 10) {
                updateGUIToTeam();
            }
        }//GEN-LAST:event_teamSearchFieldKeyPressed

        private void lwListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lwListMouseClicked
            if (evt.getClickCount() == 2) {
                String name = (String) lwList.getSelectedValue();
                playerTab.setSelectedIndex(2);
                searchField.setText(name);
                searchPlayer.doClick();
            }
        }//GEN-LAST:event_lwListMouseClicked

        private void cListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cListMouseClicked
            if (evt.getClickCount() == 2) {
                String name = (String) cList.getSelectedValue();
                playerTab.setSelectedIndex(2);
                searchField.setText(name);
                searchPlayer.doClick();
            }
        }//GEN-LAST:event_cListMouseClicked

        private void rwListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rwListMouseClicked
            if (evt.getClickCount() == 2) {
                String name = (String) rwList.getSelectedValue();
                playerTab.setSelectedIndex(2);
                searchField.setText(name);
                searchPlayer.doClick();
            }
        }//GEN-LAST:event_rwListMouseClicked

        private void dListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dListMouseClicked
            if (evt.getClickCount() == 2) {
                String name = (String) dList.getSelectedValue();
                playerTab.setSelectedIndex(2);
                searchField.setText(name);
                searchPlayer.doClick();
            }
        }//GEN-LAST:event_dListMouseClicked

        private void gListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_gListMouseClicked
            if (evt.getClickCount() == 2) {
                String name = (String) gList.getSelectedValue();
                playerTab.setSelectedIndex(2);
                searchField.setText(name);
                searchPlayer.doClick();
            }
        }//GEN-LAST:event_gListMouseClicked

        private void draftLwListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_draftLwListMouseClicked
            if (evt.getClickCount() == 2) {
                String name = (String) draftLwList.getSelectedValue();
                playerTab.setSelectedIndex(2);
                searchField.setText(name);
                searchPlayer.doClick();
            }
        }//GEN-LAST:event_draftLwListMouseClicked

        private void draftCListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_draftCListMouseClicked
            if (evt.getClickCount() == 2) {
                String name = (String) draftCList.getSelectedValue();
                playerTab.setSelectedIndex(2);
                searchField.setText(name);
                searchPlayer.doClick();
            }
        }//GEN-LAST:event_draftCListMouseClicked

        private void draftRwListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_draftRwListMouseClicked
            if (evt.getClickCount() == 2) {
                String name = (String) draftRwList.getSelectedValue();
                playerTab.setSelectedIndex(2);
                searchField.setText(name);
                searchPlayer.doClick();
            }
        }//GEN-LAST:event_draftRwListMouseClicked

        private void draftDListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_draftDListMouseClicked
            if (evt.getClickCount() == 2) {
                String name = (String) draftDList.getSelectedValue();
                playerTab.setSelectedIndex(2);
                searchField.setText(name);
                searchPlayer.doClick();
            }
        }//GEN-LAST:event_draftDListMouseClicked

        private void draftGListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_draftGListMouseClicked
            if (evt.getClickCount() == 2) {
                String name = (String) draftGList.getSelectedValue();
                playerTab.setSelectedIndex(2);
                searchField.setText(name);
                searchPlayer.doClick();
            }
        }//GEN-LAST:event_draftGListMouseClicked

        private void myDraftListKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_myDraftListKeyPressed
           if (evt.getKeyCode() == KeyEvent.VK_DELETE) {
                DefaultListModel temp=new DefaultListModel();
                for (int i=0;i<myDraftList.getModel().getSize();i++){
                    if (i!=myDraftList.getSelectedIndex())
                      temp.addElement(myDraftList.getModel().getElementAt(i));
                }
                myDraftList.setModel(temp);
            }
        }//GEN-LAST:event_myDraftListKeyPressed

        private void draftBestAvailableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_draftBestAvailableMouseClicked
           if (evt.getClickCount() == 2) {
                String name = (String) draftBestAvailable.getSelectedValue();
                int space=name.indexOf(" ")+1;
                name=name.substring(space, name.length()-3);
                playerTab.setSelectedIndex(2);
                searchField.setText(name);
                searchPlayer.doClick();
            }
        }//GEN-LAST:event_draftBestAvailableMouseClicked

        private void myDraftListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_myDraftListMouseClicked
                if (evt.getClickCount() == 2) {
                String name = (String)myDraftList.getSelectedValue();
                int space=name.indexOf(" ")+1;
                name=name.substring(space, name.length()-3);
                playerTab.setSelectedIndex(2);
                searchField.setText(name);
                searchPlayer.doClick();
            }
        }//GEN-LAST:event_myDraftListMouseClicked

        private void queueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queueButtonActionPerformed
            String fileName = JOptionPane.showInputDialog("Enter desired file name");
            System.out.println(fileName);
            fileName.replaceAll("[.,;:!@#$%^* ]", "");
            if (fileName.equalsIgnoreCase("players") || fileName.equalsIgnoreCase("league")) {
                JOptionPane.showMessageDialog(this, "Bad file name choice");
            } else {
            ArrayList<String>queue=new ArrayList<String>();
            for (int i=0;i<myDraftList.getModel().getSize();i++){
                String name=(String)myDraftList.getModel().getElementAt(i);
                name=name.substring(0,name.length()-3);
                queue.add(name);
            }
            fH.writeDraftQueue(queue, fileName);
            }
        }//GEN-LAST:event_queueButtonActionPerformed

        private void comparePlayerField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comparePlayerField1KeyPressed
            // TODO add your handling code here:
        }//GEN-LAST:event_comparePlayerField1KeyPressed

        private void comparePlayerField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_comparePlayerField2KeyPressed
            if (evt.getKeyCode() == 10) {
                comparePlayers();
            }
        }//GEN-LAST:event_comparePlayerField2KeyPressed

        private void curOA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curOA1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_curOA1ActionPerformed

        private void trainOA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainOA1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_trainOA1ActionPerformed

        private void farmOA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_farmOA2ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_farmOA2ActionPerformed

        private void comparePlayerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comparePlayerButtonActionPerformed
            comparePlayers();
        }//GEN-LAST:event_comparePlayerButtonActionPerformed

        private void curSHOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curSHOActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCurSHO(Integer.parseInt(curSHO.getText()));
        }//GEN-LAST:event_curSHOActionPerformed

        private void curPLAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curPLAActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCurPLA(Integer.parseInt(curPLA.getText()));
}//GEN-LAST:event_curPLAActionPerformed

        private void curSTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curSTKActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCurSTK(Integer.parseInt(curSTK.getText()));
        }//GEN-LAST:event_curSTKActionPerformed

        private void curCHKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curCHKActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCurCHK(Integer.parseInt(curCHK.getText()));
        }//GEN-LAST:event_curCHKActionPerformed

        private void curPOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curPOSActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCurPOS(Integer.parseInt(curPOS.getText()));
        }//GEN-LAST:event_curPOSActionPerformed

        private void curHITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curHITActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCurHIT(Integer.parseInt(curHIT.getText()));
        }//GEN-LAST:event_curHITActionPerformed

        private void curSKAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curSKAActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCurSKA(Integer.parseInt(curSKA.getText()));
        }//GEN-LAST:event_curSKAActionPerformed

        private void curENDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curENDActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCurEND(Integer.parseInt(curEND.getText()));
        }//GEN-LAST:event_curENDActionPerformed

        private void curPENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curPENActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setPEN(Integer.parseInt(curPEN.getText()));
        }//GEN-LAST:event_curPENActionPerformed

        private void curFACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curFACActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCurFAC(Integer.parseInt(curFAC.getText()));
        }//GEN-LAST:event_curFACActionPerformed

        private void curLEAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curLEAActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setLEA(Integer.parseInt(curLEA.getText()));
        }//GEN-LAST:event_curLEAActionPerformed

        private void curFIGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curFIGActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCurFGT(Integer.parseInt(curFIG.getText()));
        }//GEN-LAST:event_curFIGActionPerformed

        private void curSTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_curSTRActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCurSTR(Integer.parseInt(curSTR.getText()));
        }//GEN-LAST:event_curSTRActionPerformed

        private void POTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_POTActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setPOT(Integer.parseInt(POT.getText()));
        }//GEN-LAST:event_POTActionPerformed

        private void CONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CONActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCON(Integer.parseInt(CON.getText()));
        }//GEN-LAST:event_CONActionPerformed

        private void GRDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GRDActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setGRD(Integer.parseInt(GRD.getText()));
        }//GEN-LAST:event_GRDActionPerformed

        private void ceilSHOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilSHOActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCeilSHO(Integer.parseInt(ceilSHO.getText()));
        }//GEN-LAST:event_ceilSHOActionPerformed

        private void ceilPLAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilPLAActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCeilPLA(Integer.parseInt(ceilPLA.getText()));
        }//GEN-LAST:event_ceilPLAActionPerformed

        private void ceilSTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilSTKActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCeilSTK(Integer.parseInt(ceilSTK.getText()));
        }//GEN-LAST:event_ceilSTKActionPerformed

        private void ceilCHKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilCHKActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCeilCHK(Integer.parseInt(ceilCHK.getText()));
        }//GEN-LAST:event_ceilCHKActionPerformed

        private void ceilPOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilPOSActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCeilPOS(Integer.parseInt(ceilPOS.getText()));
        }//GEN-LAST:event_ceilPOSActionPerformed

        private void ceilHITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilHITActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCeilHIT(Integer.parseInt(ceilHIT.getText()));
        }//GEN-LAST:event_ceilHITActionPerformed

        private void ceilSKAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilSKAActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCeilSKA(Integer.parseInt(ceilSKA.getText()));
        }//GEN-LAST:event_ceilSKAActionPerformed

        private void ceilENDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilENDActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCeilEND(Integer.parseInt(ceilEND.getText()));
        }//GEN-LAST:event_ceilENDActionPerformed

        private void ceilPENActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilPENActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCeilPEN(Integer.parseInt(ceilPEN.getText()));
        }//GEN-LAST:event_ceilPENActionPerformed

        private void ceilFACActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilFACActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCeilFAC(Integer.parseInt(ceilFAC.getText()));
        }//GEN-LAST:event_ceilFACActionPerformed

        private void ceilLEAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilLEAActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCeilLEA(Integer.parseInt(ceilLEA.getText()));
        }//GEN-LAST:event_ceilLEAActionPerformed

        private void ceilFIGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilFIGActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCeilFGT(Integer.parseInt(ceilFIG.getText()));
        }//GEN-LAST:event_ceilFIGActionPerformed

        private void ceilSTRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilSTRActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCeilSTR(Integer.parseInt(ceilSTR.getText()));
        }//GEN-LAST:event_ceilSTRActionPerformed

        private void playerPanelAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_playerPanelAncestorAdded

        }//GEN-LAST:event_playerPanelAncestorAdded

        private void writePlayersFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_writePlayersFileActionPerformed
                fH.writePlayersFile(playerSet);
        }//GEN-LAST:event_writePlayersFileActionPerformed

        private void ceilSHO1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilSHO1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_ceilSHO1ActionPerformed

        private void ceilPLA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilPLA1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_ceilPLA1ActionPerformed

        private void ceilSTK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilSTK1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_ceilSTK1ActionPerformed

        private void ceilCHK1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilCHK1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_ceilCHK1ActionPerformed

        private void ceilPOS1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilPOS1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_ceilPOS1ActionPerformed

        private void ceilHIT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilHIT1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_ceilHIT1ActionPerformed

        private void ceilSKA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilSKA1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_ceilSKA1ActionPerformed

        private void ceilEND1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilEND1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_ceilEND1ActionPerformed

        private void ceilPEN1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilPEN1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_ceilPEN1ActionPerformed

        private void ceilFAC1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilFAC1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_ceilFAC1ActionPerformed

        private void ceilLEA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilLEA1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_ceilLEA1ActionPerformed

        private void ceilFIG1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilFIG1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_ceilFIG1ActionPerformed

        private void ceilSTR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ceilSTR1ActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_ceilSTR1ActionPerformed

        private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setpStatus(Integer.parseInt(status.getText()));// TODO add your handling code here:
        }//GEN-LAST:event_statusActionPerformed

        private void clickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clickActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setCLK(Integer.parseInt(click.getText()));
        }//GEN-LAST:event_clickActionPerformed

        private void handActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_handActionPerformed
            if (foundPlayer!=null){
                int handed=0;
                if (hand.getText().equalsIgnoreCase("L"))
                    handed=1;
                foundPlayer.setHanded(handed);
            }
        }//GEN-LAST:event_handActionPerformed

        private void weightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weightActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setWeight(Integer.parseInt(weight.getText()));
        }//GEN-LAST:event_weightActionPerformed

        private void heightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_heightActionPerformed
            if (foundPlayer!=null){
                String h=height.getText();
                int s=0;
                if (h.equalsIgnoreCase("5-5"))
			s=0;
		else if (h.equalsIgnoreCase("5-6"))
			s=1;
		else if (h.equalsIgnoreCase("5-7"))
			s=2;
		else if (h.equalsIgnoreCase("5-8"))
			s=3;
		else if (h.equalsIgnoreCase("5-9"))
			s=4;
		else if (h.equalsIgnoreCase("5-10"))
			s=5;
		else if (h.equalsIgnoreCase("5-11"))
			s=6;
		else if (h.equalsIgnoreCase("6-0"))
			s=7;
		else if (h.equalsIgnoreCase("6-1"))
			s=8;
		else if (h.equalsIgnoreCase("6-2"))
			s=9;
		else if (h.equalsIgnoreCase("6-3"))
			s=10;
		else if (h.equalsIgnoreCase("6-4"))
			s=11;
		else if (h.equalsIgnoreCase("6-5"))
			s=12;
		else if (h.equalsIgnoreCase("6-6"))
			s=13;
		else if (h.equalsIgnoreCase("6-7"))
			s=14;
		else if (h.equalsIgnoreCase("6-8"))
			s=15;
		else if (h.equalsIgnoreCase("6-9"))
			s=16;
		else if (h.equalsIgnoreCase("6-10"))
			s=17;
		else if (h.equalsIgnoreCase("6-11"))
			s=18;
		else if (h.equalsIgnoreCase("7-0")) {
			s=19;
		}
                foundPlayer.setHeight(s);
            }
        }//GEN-LAST:event_heightActionPerformed

        private void salaryAmtConsideringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryAmtConsideringActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setOfferData(Integer.parseInt(salaryAmt.getText()));
        }//GEN-LAST:event_salaryAmtConsideringActionPerformed

        private void salaryYrConsideringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryYrConsideringActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setTimeConsidering(Integer.parseInt(salaryYrConsidering.getText()));
        }//GEN-LAST:event_salaryYrConsideringActionPerformed

        private void twoWayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_twoWayActionPerformed
            if (foundPlayer!=null){
                int way2=0;
                if (twoWay.getText().equalsIgnoreCase("Yes"))
                    way2=1;
                foundPlayer.setTwoWay(way2);
            }
        }//GEN-LAST:event_twoWayActionPerformed

        private void salaryAmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryAmtActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setSalary(Integer.parseInt(salaryAmt.getText()));
        }//GEN-LAST:event_salaryAmtActionPerformed

        private void salaryYrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salaryYrActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setContractYr(Integer.parseInt(salaryYr.getText()));
        }//GEN-LAST:event_salaryYrActionPerformed

        private void draftTeamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_draftTeamActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setDraftTeam(Integer.parseInt(draftTeam.getText()));
        }//GEN-LAST:event_draftTeamActionPerformed

        private void draftPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_draftPosActionPerformed
            if (foundPlayer!=null){
                JOptionPane.showMessageDialog(this, "To successfully alter draft position, first make sure the draft round is what you want.  The utility also does not support rounds with more than 30 picks");
                int overallDFT=(foundPlayer.getDraftRd()-1)*30+Integer.parseInt(draftPos.getText());
                foundPlayer.setOverallDraft(overallDFT);
            }
        }//GEN-LAST:event_draftPosActionPerformed

        private void draftRdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_draftRdActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setDraftRd(Integer.parseInt(draftRd.getText()));
        }//GEN-LAST:event_draftRdActionPerformed

        private void draftYrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_draftYrActionPerformed
            if (foundPlayer!=null)
                foundPlayer.setDraftYr(Integer.parseInt(draftYr.getText()));
        }//GEN-LAST:event_draftYrActionPerformed

        private void rightsFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightsFieldActionPerformed
            if (foundPlayer!=null){
                String rights=rightsField.getText();
                int num=98;
                if (rights.equalsIgnoreCase("DFT")||rights.equalsIgnoreCase("Draft"))
			num=99;
		else if (rights.equalsIgnoreCase("ANA"))
			num=1;
		else if (rights.equalsIgnoreCase("ATL"))
			num=2;
		else if (rights.equalsIgnoreCase("BOS"))
			num=3;
		else if (rights.equalsIgnoreCase("BUF"))
			num=4;
		else if (rights.equalsIgnoreCase("CGY"))
			num=5;
		else if (rights.equalsIgnoreCase("CAR"))
			num=6;
		else if (rights.equalsIgnoreCase("CHI"))
			num=7;
		else if (rights.equalsIgnoreCase("COL"))
			num=8;
		else if (rights.equalsIgnoreCase("CBS")||rights.equalsIgnoreCase("CBJ"))
			num=9;
		else if (rights.equalsIgnoreCase("DAL"))
			num=10;
		else if (rights.equalsIgnoreCase("DET"))
			num=11;
		else if (rights.equalsIgnoreCase("EDM"))
			num=12;
		else if (rights.equalsIgnoreCase("FLA"))
			num=13;
		else if (rights.equalsIgnoreCase("LA"))
			num=14;
		else if (rights.equalsIgnoreCase("MIN"))
			num=15;
		else if (rights.equalsIgnoreCase("MTL")||rights.equalsIgnoreCase("MON"))
			num=16;
		else if (rights.equalsIgnoreCase("NYI"))
			num=17;
		else if (rights.equalsIgnoreCase("NYR"))
			num=18;
		else if (rights.equalsIgnoreCase("NSH")||rights.equalsIgnoreCase("NAS"))
			num=19;
		else if (rights.equalsIgnoreCase("NJ"))
			num=20;
		else if (rights.equalsIgnoreCase("OTT"))
			num=21;
		else if (rights.equalsIgnoreCase("PHI"))
			num=22;
		else if (rights.equalsIgnoreCase("PHO")||rights.equalsIgnoreCase("PHX"))
			num=23;
		else if (rights.equalsIgnoreCase("PIT"))
			num=24;
		else if (rights.equalsIgnoreCase("SJ"))
			num=25;
		else if (rights.equalsIgnoreCase("STL"))
			num=26;
		else if (rights.equalsIgnoreCase("TB"))
			num=27;
		else if (rights.equalsIgnoreCase("TOR"))
			num=28;
		else if (rights.equalsIgnoreCase("VAN"))
			num=29;
                else if(rights.equalsIgnoreCase("WSH") || rights.equalsIgnoreCase("WAS")) {
			num=30;
		}
                foundPlayer.setRights(num);
                foundPlayer.setNhlRights(num);
                foundPlayer.setTEAM(num);
            }
        }//GEN-LAST:event_rightsFieldActionPerformed

        private void altPOSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altPOSIActionPerformed
            if (foundPlayer!=null){
             String POSI=altPOSI.getText();
             int num=1;
                if (POSI.equalsIgnoreCase("G")) 
                    num=1;
		else if (POSI.equalsIgnoreCase("D"))
                    num=2;
		else if (POSI.equalsIgnoreCase("L"))
                    num=3;
		else if (POSI.equalsIgnoreCase("C"))
                    num=4;
		else if (POSI.equalsIgnoreCase("R"))
                    num=5;
		foundPlayer.setAltPOSI(num);   
            }
        }//GEN-LAST:event_altPOSIActionPerformed

        private void mainPOSIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainPOSIActionPerformed
            if (foundPlayer!=null){
             String POSI=mainPOSI.getText();
             int num=1;
                if (POSI.equalsIgnoreCase("G"))
                    num=1;
		else if (POSI.equalsIgnoreCase("D"))
                    num=2;
		else if (POSI.equalsIgnoreCase("L"))
                    num=3;
		else if (POSI.equalsIgnoreCase("C"))
                    num=4;
		else if (POSI.equalsIgnoreCase("R"))
                    num=5;
		foundPlayer.setPOSI(num);   
            }
        }//GEN-LAST:event_mainPOSIActionPerformed

        private void faqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_faqActionPerformed
             JOptionPane.showMessageDialog(this,"FAQ: Players Tab:\n"
                     + "Q: Why can't I edit the projected skills?\n"
                     + "A: Projected skills are not saved in the players file; the only way to change them is to change the ceiling for that skill and/or POT.\n"
                     + "Q: Why can't I edit the Player types?\n"
                     + "A: Player types are represented by the second number of the POT in the players file, thus change the second number of the pot to change player types.\n"
                     + "Q: Why isn't there a GP record, GP GWG, current assist streak, or current GWG streak?\n"
                     + "A: The players file doesn't keep track of those.\n"
                     + "Q: What is the similar players list?\n"
                     + "A: A list of players with the same POT and CON.\n"
                     + "Q: Why can't I change the Age?\n"
                     + "A: EHM only keeps track of the birth year, day, and month; therefore, you would have to change each of those and right now they're not displayed on the GUI.\n"
                     + "Q: Why can't I change the team to a farm team?\n"
                     + "A: This feature is not currently implemented.\n"
                     + "Q: Why doesn't editing the height, position, or handedness work?\n"
                     + "A: Make sure you're editing it in the right format.  For Height it must be between '5-5' and '7-0'. For Position it must be either 'G', 'D', 'L', 'C', or 'R'. Handedness must be either 'L' or 'R'.\n"
                     + "Q: Why are unusual numbers appearing for the stats?\n"
                     + "A: The stats are just raw data from the players file, so that's how EHM stores it.\n"
                     + "\nTeam tab:\n"
                     + "Q: What is the format for the team search?\n"
                     + "A: Enter the full name for the team. For example: Columbus, Florida, Boston, etc. For teams with the same city/state name and example of the format is New York I and New York R. Enter 'Draft' for draft and 'Free agent' for free agency.\n"
                     + "\nCompare Players Tab:\n"
                     + "Q: What do the green and red backgrounds signify?\n"
                     + "A: Green means the first player has more of that than the second player. Red means the first player has less of that than the second player.\n"
                     + "Q: What skills are taken into account for the result area?\n"
                     + "A: All current and projected skills except the offense, defense, and overall average.\n"
                     + "\nDraft Tab:\n"
                     + "Q: Why doesn't the draft drop down list have all the years?\n"
                     + "A: Currently the draft drop down only supports 2009-2016 and the current draft year which may be listed under 2017. Hopefully this will be better implemented in the future.\n"
                     + "Q: Why does the current draft year only have 150 players.\n"
                     + "A: The top 150 players according to projected overall are used to give an indication of the strength of the draft. To get the full list of draft picks use the team tab.\n"
                     + "Q: How does the draft queue work?\n"
                     + "A: simply drag and drop from the other lists. To delete an item on the queue just select it and presse 'delete'. To save your list, you can create a text file of it using the button.\n"
                     + "Q: Is it possible to load a draft list?\n"
                     + "A: No, but this may be added in the future.\n");
        }//GEN-LAST:event_faqActionPerformed

    public void updateGUIToPlayer() {
        searchField.setText(foundPlayer.getFullName());
        ArrayList<String> skills = foundPlayer.getAllInfoList();
        for (int i = 0; i < skills.size(); i++) {
            list.get(i).setText(skills.get(i));
        }
        salaryAmtConsidering.setToolTipText("Team Offering: " + foundPlayer.getStringFromNum(foundPlayer.getOfferTeam()));
        ArrayList<Player> ap = foundPlayer.getClosePlayerMatches(fH.getPlayerList());
        String[] a = new String[ap.size()];
        for (int i = 0; i < a.length; i++) {
            a[i] = ap.get(i).getFullName();
        }
        similarPlayerList.setListData(a);

        
        playerID.setText("" + foundPlayer.getId());
        if (foundPlayer.getRights()==99)
            playerIcon.setIcon(teamList.get(30).getImageIcon(fH.getFilePath()));
        else if(foundPlayer.getRights() == 98)
            playerIcon.setIcon(teamList.get(31).getImageIcon(fH.getFilePath()));
        else
            playerIcon.setIcon(teamList.get(foundPlayer.getRights()-1).getImageIcon(fH.getFilePath()));

        playerIcon.setText("");
        playerTypeP1.setText(""+foundPlayer.playerType());
        playerTypeP2.setText(""+foundPlayer.playerType2());

    }

    public void updateGUIToTeam() {
        Team team = getTeamSearched(teamSearchField.getText());
        team.sortPlayersToLists();
        teamIcon.setIcon(team.getImageIcon(fH.getFilePath()));
        teamIcon.setText("");
        proSalary.setText("" + team.getProSalary());
        farmSalary.setText("" + team.getFarmSalary());
        numPlayers.setText("" + team.getAllPlayers().size());
        if (team.getName().equalsIgnoreCase("Draft")||team.getName().equalsIgnoreCase("Free Agent")){
            allButton.setSelected(true);
            proOffense.setText("");
            proDefense.setText("");
            proOA.setText("");
            numPlayersPro.setText("");
            numPlayersFarm.setText("");
            numPlayersProsp.setText("");
            lwList.setListData(team.getLeftWing(team.getAllPlayers()));
            cList.setListData(team.getCenter(team.getAllPlayers()));
            rwList.setListData(team.getRightWing(team.getAllPlayers()));
            dList.setListData(team.getDefense(team.getAllPlayers()));
            gList.setListData(team.getGoalie(team.getAllPlayers()));
        }
        else{
        proOffense.setText("" + team.offenseAverage());
        proDefense.setText("" + team.defenseAverage());
        proOA.setText("" + team.overallAverage());
        numPlayersPro.setText("" + team.getProPlayers().size());
        numPlayersFarm.setText("" + team.getFarmPlayers().size());
        numPlayersProsp.setText("" + team.getProspects().size());
        if (proTeamButton.isSelected()) {
            lwList.setListData(team.getLeftWing(team.getProPlayers()));
            cList.setListData(team.getCenter(team.getProPlayers()));
            rwList.setListData(team.getRightWing(team.getProPlayers()));
            dList.setListData(team.getDefense(team.getProPlayers()));
            gList.setListData(team.getGoalie(team.getProPlayers()));
        } else if (farmTeamButton.isSelected()) {
            lwList.setListData(team.getLeftWing(team.getFarmPlayers()));
            cList.setListData(team.getCenter(team.getFarmPlayers()));
            rwList.setListData(team.getRightWing(team.getFarmPlayers()));
            dList.setListData(team.getDefense(team.getFarmPlayers()));
            gList.setListData(team.getGoalie(team.getFarmPlayers()));
        } else if (prospectsButton.isSelected()) {
            lwList.setListData(team.getLeftWing(team.getProspects()));
            cList.setListData(team.getCenter(team.getProspects()));
            rwList.setListData(team.getRightWing(team.getProspects()));
            dList.setListData(team.getDefense(team.getProspects()));
            gList.setListData(team.getGoalie(team.getProspects()));
        } else {
            lwList.setListData(team.getLeftWing(team.getAllPlayers()));
            cList.setListData(team.getCenter(team.getAllPlayers()));
            rwList.setListData(team.getRightWing(team.getAllPlayers()));
            dList.setListData(team.getDefense(team.getAllPlayers()));
            gList.setListData(team.getGoalie(team.getAllPlayers()));
        }
        String[] tempNames = new String[team.getProPlayers().size()];
        for (int i = 0; i < tempNames.length; i++) {
            tempNames[i] = team.getProPlayers().get(i).getFullName();
        }
        avgProOverall();
        avgProDefense();
        avgProOffense();
        //strengthOfDrafts();
        }
    }

    public void updateGUIToDraft(ArrayList<Player> p, Team draft) {
        double tempOf = 0;
        double tempDf = 0;
        double tempOA = 0;
        double pOf = 0;
        double pDf = 0;
        double pOA = 0;
        double tOf = 0;
        double tDF = 0;
        double tOA = 0;
        double tempOf1 = 0;
        double tempDf1 = 0;
        double tempOA1 = 0;
        double pOf1 = 0;
        double pDf1 = 0;
        double pOA1 = 0;
        double tOf1 = 0;
        double tDF1 = 0;
        double tOA1 = 0;
        double tempOf2 = 0;
        double tempDf2 = 0;
        double tempOA2 = 0;
        double pOf2 = 0;
        double pDf2 = 0;
        double pOA2 = 0;
        double tOf2 = 0;
        double tDF2 = 0;
        double tOA2 = 0;
        double tempOf3 = 0;
        double tempDf3 = 0;
        double tempOA3 = 0;
        double pOf3 = 0;
        double pDf3 = 0;
        double pOA3 = 0;
        double tOf3 = 0;
        double tDF3 = 0;
        double tOA3 = 0;
        double tempOf4 = 0;
        double tempDf4 = 0;
        double tempOA4 = 0;
        double pOf4 = 0;
        double pDf4 = 0;
        double pOA4 = 0;
        double tOf4 = 0;
        double tDF4 = 0;
        double tOA4 = 0;
        double tempOf5 = 0;
        double tempDf5 = 0;
        double tempOA5 = 0;
        double pOf5 = 0;
        double pDf5 = 0;
        double pOA5 = 0;
        double tOf5 = 0;
        double tDF5 = 0;
        double tOA5 = 0;
        int numRd1 = 0;
        int numRd2 = 0;
        int numRd3 = 0;
        int numRd4 = 0;
        int numRd5 = 0;
        draftLwList.setListData(draft.getLeftWing(p));
        draftCList.setListData(draft.getCenter(p));
        draftRwList.setListData(draft.getRightWing(p));
        draftDList.setListData(draft.getDefense(p));
        draftGList.setListData(draft.getGoalie(p));
        for (Player d : p) {
            tempOf += d.getOffense();
            pOf += d.getpOFF();
            tOf += d.getTRO();
            tempDf += d.getDefense();
            pDf += d.getpDF();
            tDF += d.getTRD();
            tempOA += d.getOA();
            pOA += d.getpOA() / 6;
            tOA += d.getTROA();

            if (d.getDraftRd() == 1) {
                numRd1++;
                tempOf1 += d.getOffense();
                pOf1 += d.getpOFF();
                tOf1 += d.getTRO();
                tempDf1 += d.getDefense();
                pDf1 += d.getpDF();
                tDF1 += d.getTRD();
                tempOA1 += d.getOA();
                pOA1 += d.getpOA() / 6;
                tOA1 += d.getTROA();
            } else if (d.getDraftRd() == 2) {
                numRd2++;
                tempOf2 += d.getOffense();
                pOf2 += d.getpOFF();
                tOf2 += d.getTRO();
                tempDf2 += d.getDefense();
                pDf2 += d.getpDF();
                tDF2 += d.getTRD();
                tempOA2 += d.getOA();
                pOA2 += d.getpOA() / 6;
                tOA2 += d.getTROA();
            } else if (d.getDraftRd() == 3) {
                numRd3++;
                tempOf3 += d.getOffense();
                pOf3 += d.getpOFF();
                tOf3 += d.getTRO();
                tempDf3 += d.getDefense();
                pDf3 += d.getpDF();
                tDF3 += d.getTRD();
                tempOA3 += d.getOA();
                pOA3 += d.getpOA() / 6;
                tOA3 += d.getTROA();
            } else if (d.getDraftRd() == 4) {
                numRd4++;
                tempOf4 += d.getOffense();
                pOf4 += d.getpOFF();
                tOf4 += d.getTRO();
                tempDf4 += d.getDefense();
                pDf4 += d.getpDF();
                tDF4 += d.getTRD();
                tempOA4 += d.getOA();
                pOA4 += d.getpOA() / 6;
                tOA4 += d.getTROA();
            } else if (d.getDraftRd() == 5) {
                numRd5++;
                tempOf5 += d.getOffense();
                pOf5 += d.getpOFF();
                tOf5 += d.getTRO();
                tempDf5 += d.getDefense();
                pDf5 += d.getpDF();
                tDF5 += d.getTRD();
                tempOA5 += d.getOA();
                pOA5 += d.getpOA() / 6;
                tOA5 += d.getTROA();
            }
        }
        System.out.println("POA is: "+pOA);
            String temp = "" + tempOf / p.size();
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftOF.setText("" + temp);
            temp = "" + tempDf / p.size();
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftDF.setText(temp);
            temp = "" + tempOA / p.size();
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftOA.setText(temp);
            temp = "" + pOf / p.size();
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPOF.setText("" + temp);
            temp = "" + pDf / p.size();
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPDF.setText(temp);
            temp = "" + pOA / p.size();
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPOA.setText(temp);

            temp = "" + tOf / p.size();
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTOF.setText("" + temp);
            temp = "" + tDF / p.size();
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTDF.setText(temp);
            temp = "" + tOA / p.size();
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTOA.setText(temp);
            temp = "" + tempOf1 / numRd1;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }

            if (numRd1 != 0) {
            draftOF1.setText("" + temp);
            temp = "" + tempDf1 / numRd1;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftDF1.setText(temp);
            temp = "" + tempOA1 / numRd1;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftOA1.setText(temp);
            temp = "" + pOf1 / numRd1;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPOF1.setText("" + temp);
            temp = "" + pDf1 / numRd1;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPDF1.setText(temp);
            temp = "" + pOA1 / numRd1;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPOA1.setText(temp);

            temp = "" + tOf1 / numRd1;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTOF1.setText("" + temp);
            temp = "" + tDF1 / numRd1;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTDF1.setText(temp);
            temp = "" + tOA1 / numRd1;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTOA1.setText(temp);
            temp = "" + tempOf2 / numRd2;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftOF2.setText("" + temp);
            temp = "" + tempDf2 / numRd2;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftDF2.setText(temp);
            temp = "" + tempOA2 / numRd2;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftOA2.setText(temp);
            temp = "" + pOf2 / numRd2;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPOF2.setText("" + temp);
            temp = "" + pDf2 / numRd2;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPDF2.setText(temp);
            temp = "" + pOA2 / numRd2;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPOA2.setText(temp);

            temp = "" + tOf2 / numRd2;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTOF2.setText("" + temp);
            temp = "" + tDF2 / numRd2;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTDF2.setText(temp);
            temp = "" + tOA2 / numRd2;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTOA2.setText(temp);

            temp = "" + tempOf3 / numRd3;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftOF3.setText("" + temp);
            temp = "" + tempDf3 / numRd3;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftDF3.setText(temp);
            temp = "" + tempOA3 / numRd3;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftOA3.setText(temp);
            temp = "" + pOf3 / numRd3;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPOF3.setText("" + temp);
            temp = "" + pDf3 / numRd3;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPDF3.setText(temp);
            temp = "" + pOA3 / numRd3;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPOA3.setText(temp);
            temp = "" + tOf3 / numRd3;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTOF3.setText("" + temp);
            temp = "" + tDF3 / numRd3;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTDF3.setText(temp);
            temp = "" + tOA3 / numRd3;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTOA3.setText(temp);
            temp = "" + tempOf4 / numRd4;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftOF4.setText("" + temp);
            temp = "" + tempDf4 / numRd4;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftDF4.setText(temp);
            temp = "" + tempOA4 / numRd4;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftOA4.setText(temp);
            temp = "" + pOf4 / numRd4;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPOF4.setText("" + temp);
            temp = "" + pDf4 / numRd4;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPDF4.setText(temp);
            temp = "" + pOA4 / numRd4;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPOA4.setText(temp);

            temp = "" + tOf4 / numRd4;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTOF4.setText("" + temp);
            temp = "" + tDF4 / numRd4;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTDF4.setText(temp);
            temp = "" + tOA4 / numRd4;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTOA4.setText(temp);
            temp = "" + tempOf5 / numRd5;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftOF5.setText("" + temp);
            temp = "" + tempDf5 / numRd5;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftDF5.setText(temp);
            temp = "" + tempOA5 / numRd5;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftOA5.setText(temp);
            temp = "" + pOf5 / numRd5;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPOF5.setText("" + temp);
            temp = "" + pDf5 / numRd5;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPDF5.setText(temp);
            temp = "" + pOA5 / numRd5;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftPOA5.setText(temp);

            temp = "" + tOf5 / numRd5;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTOF5.setText("" + temp);
            temp = "" + tDF5 / numRd5;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTDF5.setText(temp);
            temp = "" + tOA5 / numRd5;
            if (temp.length() > 5) {
                temp = temp.substring(0, 6);
            }
            draftTOA5.setText(temp);
        }
        numPlayersDraft.setText("" + p.size());
    }

    public void avgProOverall() {
        double d = 0;
        double counter = 0;
        for (Team a : teamList) {
            a.sortPlayersToLists();
            for (Player p : a.getProPlayers()) {
                d += p.getOA();
                counter++;
            }
        }
        System.out.println("average overall: " + d / counter);
    }

    public void avgProDefense() {
        double d = 0;
        double counter = 0;
        for (Team a : teamList) {
            a.sortPlayersToLists();
            for (Player p : a.getProPlayers()) {
                d += p.getDefense();
                counter++;
            }
        }
        System.out.println("average defense: " + d / counter);
    }

    public void avgProOffense() {
        double d = 0;
        double counter = 0;
        for (Team a : teamList) {
            a.sortPlayersToLists();
            for (Player p : a.getProPlayers()) {
                d += p.getOffense();
                counter++;
            }
        }
        System.out.println("average offense: " + d / counter);
    }

    public void strengthOfDrafts() {
        double d09 = 0;
        double c09 = 0;
        double d10 = 0;
        double c10 = 0;
        double d11 = 0;
        double c11 = 0;
        double d12 = 0;
        double c12 = 0;
        double d13 = 0;
        double c13 = 0;
        double d14 = 0;
        double c14 = 0;
        double d15 = 0;
        double c15 = 0;
        double d16 = 0;
        double c16 = 0;
        double d17 = 0;
        double c17 = 0;
        for (Player p : playerSet) {
            if (p.getDraftYr() == 2009) {
                d09 += p.getpOA() / 6;
                c09++;
            } else if (p.getDraftYr() == 2010) {
                d10 += p.getpOA() / 6;
                c10++;
            } else if (p.getDraftYr() == 2011) {
                d11 += p.getpOA() / 6;
                c11++;
            } else if (p.getDraftYr() == 2012) {
                d12 += p.getpOA() / 6;
                c12++;
            } else if (p.getDraftYr() == 2013) {
                d13 += p.getpOA() / 6;
                c13++;
            } else if (p.getDraftYr() == 2014) {
                d14 += p.getpOA() / 6;
                c14++;
            } else if (p.getDraftYr() == 2015) {
                d15 += p.getpOA() / 6;
                c15++;
            } else if (p.getDraftYr() == 2016) {
                d16 += p.getpOA() / 6;
                c16++;
            } else if (p.getTEAM() == 99) {
                d17 += p.getpOA() / 6;
                c17++;
            }
        }
        System.out.println(" 2009 draft average: " + d09 / c09 + "\n 2010 draft average: " + d10 / c10 + "\n 2011 draft average: " + d11 / c11
                + "\n 2012 draft average: " + d12 / c12 + "\n 2013 draft average: " + d13 / c13 + "\n 2014 draft average: " + d14 / c14
                + "\n 2015 draft average: " + d15 / c15 + "\n 2016 draft average: " + d16 / c16 + "\n 2017 draft average: " + d17 / c17);


    }

    public String getPlayerId(String name) {
        for (Player p : playerSet) {
            if (p.getFullName().equalsIgnoreCase(name)) {
                return "" + p.getId();
            }
        }
        return "99999";
    }

    public void separateDraftRounds() {
    }

    public void initializeNewFile() {
        fH.readFromPlayersFile();
        league = new League(fH.getSortedPlayers(), salaryCap);
        playerSet = fH.getSortedPlayers();
    }

    public Team getTeamSearched(String s) {
        for (Team a : teamList) {
            if (a.getName().equalsIgnoreCase(s)) {
                a.sortPlayersToLists();
                System.out.println(a.getAllPlayers().size());
                return a;
            }
        }
        return new Team("Team Not Found", new ArrayList<Player>(), -1);
    }

    public ArrayList<JFormattedTextField> getCompareTextFieldList(){
        ArrayList<JFormattedTextField>tfList=new ArrayList<JFormattedTextField>();
        tfList.add(curSHO1);
        tfList.add(curPLA1);
        tfList.add(curSTK1);
        tfList.add(curCHK1);
        tfList.add(curPOS1);
        tfList.add(curHIT1);
        tfList.add(curSKA1);
        tfList.add(curFAC1);
        tfList.add(curSTR1);
        tfList.add(curFIG1);

        tfList.add(projSHO1);
        tfList.add(projPLA1);
        tfList.add(projSTK1);
        tfList.add(projCHK1);
        tfList.add(projPOS1);
        tfList.add(projHIT1);
        tfList.add(projSKA1);
        tfList.add(projFAC1);
        tfList.add(projSTR1);
        tfList.add(projFIG1);

        tfList.add(curOF1);
        tfList.add(curDF1);
        tfList.add(curOA1);
        tfList.add(projOF1);
        tfList.add(projDF1);
        tfList.add(projOA1);
        tfList.add(trainOF1);
        tfList.add(trainDF1);
        tfList.add(trainOA1);
        tfList.add(farmOF2);
        tfList.add(farmDF2);
        tfList.add(farmOA2);

        tfList.add(curPEN1);
        tfList.add(curEND1);
        tfList.add(POT1);
        tfList.add(CON1);
        tfList.add(GRD1);
        tfList.add(INJ1);
        tfList.add(curLEA1);

        tfList.add(salaryAmt1);
        tfList.add(salaryYr1);

        return tfList;

    }

    public void comparePlayers(){
        String name1=comparePlayerField1.getText().toLowerCase();
        String name2=comparePlayerField2.getText().toLowerCase();
        Player player1=null;
        Player player2=null;
        for (Player p : playerSet) {
                if (p.getFullName().toLowerCase().contains(name1)) {
                    player1 = p;
                    comparePlayerField1.setText(p.getFullName());
                }
                if (p.getFullName().toLowerCase().contains(name2)) {
                    player2 = p;
                    comparePlayerField2.setText(p.getFullName());
                }
            }
        System.out.println(player1.getFullName()+"----"+player2.getFullName());
        if (player1!=null&&player2!=null){
              ArrayList<Integer>comparisons=player1.comparePlayers(player2);
              ArrayList<JFormattedTextField> sft=getCompareTextFieldList();
              int sum=0;

              playerTypeC1.setText(""+player1.playerType());
              playerTypeC2.setText(""+player1.playerType2());
              playerTypeC3.setText(""+player2.playerType());
              playerTypeC4.setText(""+player2.playerType2());

              posiC1.setText(""+player1.getStringPosition());
              posiC2.setText(""+player1.getStringAlternatePosition());
              posiC3.setText(""+player2.getStringPosition());
              posiC4.setText(""+player2.getStringAlternatePosition());

              for (int i=0;i<sft.size();i++){
                  if (i==sft.size()-1||i==sft.size()-2||i==20||i==21||i==22||i==23||i==24||i==25||i==29||i==30||i==31){}
                  else{
                      sum+=comparisons.get(i);
                  }
                  if (comparisons.get(i)>0){
                      sft.get(i).setBackground(Color.GREEN);
                      sft.get(i).setText("+"+comparisons.get(i));
                  }
                  else if (comparisons.get(i)<0){
                      sft.get(i).setBackground(Color.RED);
                      sft.get(i).setText(""+comparisons.get(i));
                  }
                  else{
                      sft.get(i).setText(""+comparisons.get(i));
                      sft.get(i).setBackground(Color.WHITE);}
              }
              double ageDif=player1.getAge()-player2.getAge();
              String ageDifS=""+ageDif;
                if (ageDifS.length()>5){
                    ageDifS=ageDifS.substring(0,5);
                    ageDif=Double.parseDouble(ageDifS);
                                }
              if (ageDif>0){
                      age1.setBackground(Color.GREEN);
                      age1.setText("+"+ageDif);
                  }
                  else if (ageDif<0){
                      age1.setBackground(Color.RED);
                      age1.setText(""+ageDif);
                  }
                  else{
                      age1.setText(""+ageDif);
                      age1.setBackground(Color.WHITE);
              }
              if (sum>0){
                      compareResult.setBackground(Color.GREEN);
                      compareResult.setText("+"+sum);
                  }
                  else if (sum<0){
                      compareResult.setBackground(Color.RED);
                      compareResult.setText(""+sum);
                  }
                  else{
                      compareResult.setText(""+sum);
                     compareResult.setBackground(Color.WHITE);
              }
        }
        else
            JOptionPane.showMessageDialog(this,"Player(s) not found");

    }



    //Drag and Drop List classes
      class FromTransferHandler extends TransferHandler {
        public int getSourceActions(JComponent comp) {
            return COPY_OR_MOVE;
        }

        private int index = 0;

        public Transferable createTransferable(JComponent comp) {
            index = draftBestAvailable.getSelectedIndex();
            if (index < 0 || index >= from.getSize()) {
                return null;
            }

            return new StringSelection((String)draftBestAvailable.getSelectedValue());
        }

        public void exportDone(JComponent comp, Transferable trans, int action) {
            if (action != MOVE) {
                return;
            }

            from.removeElementAt(index);
        }
    }

    class ToTransferHandler extends TransferHandler {
        int action;

        public ToTransferHandler(int action) {
            this.action = action;
        }

        public boolean canImport(TransferHandler.TransferSupport support) {
            // for the demo, we'll only support drops (not clipboard paste)
            if (!support.isDrop()) {
                return false;
            }

            // we only import Strings
            if (!support.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                return false;
            }

            boolean actionSupported = (action & support.getSourceDropActions()) == action;
            if (actionSupported) {
                support.setDropAction(action);
                return true;
            }

            return false;
        }

        public boolean importData(TransferHandler.TransferSupport support) {
            // if we can't handle the import, say so
            if (!canImport(support)) {
                return false;
            }

            // fetch the drop location
            JList.DropLocation dl = (JList.DropLocation)support.getDropLocation();

            int index = dl.getIndex();

            // fetch the data and bail if this fails
            String data;
            try {
                data = (String)support.getTransferable().getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException e) {
                return false;
            } catch (java.io.IOException e) {
                return false;
            }

            JList list = (JList)support.getComponent();
            DefaultListModel model = (DefaultListModel)list.getModel();
            model.insertElementAt(data, index);

            Rectangle rect = list.getCellBounds(index, index);
            list.scrollRectToVisible(rect);
            list.setSelectedIndex(index);
            list.requestFocusInWindow();

            return true;
        }
    }
    //Drag and drop list classes end

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new GUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField CON;
    private javax.swing.JFormattedTextField CON1;
    private javax.swing.JLabel ConsideringLabel;
    private javax.swing.JFormattedTextField GRD;
    private javax.swing.JFormattedTextField GRD1;
    private javax.swing.JFormattedTextField INJ;
    private javax.swing.JFormattedTextField INJ1;
    private javax.swing.JFormattedTextField POT;
    private javax.swing.JFormattedTextField POT1;
    private javax.swing.JComboBox TacticsLine1;
    private javax.swing.JComboBox TacticsLine2;
    private javax.swing.JComboBox TacticsLine3;
    private javax.swing.JComboBox TacticsLine4;
    private javax.swing.JComboBox TacticsPK1;
    private javax.swing.JComboBox TacticsPK2;
    private javax.swing.JComboBox TacticsPP1;
    private javax.swing.JComboBox TacticsPP2;
    private javax.swing.JFormattedTextField age;
    private javax.swing.JFormattedTextField age1;
    private javax.swing.JLabel ageLabel;
    private javax.swing.JLabel ageLabel1;
    private javax.swing.JRadioButton allButton;
    private javax.swing.JFormattedTextField altPOSI;
    private javax.swing.JLabel assistLabel;
    private javax.swing.JFormattedTextField bStreakA;
    private javax.swing.JFormattedTextField bStreakG;
    private javax.swing.JFormattedTextField bStreakGP;
    private javax.swing.JFormattedTextField bStreakGWG;
    private javax.swing.JFormattedTextField bStreakP;
    private javax.swing.JLabel bestAvailableLabel;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JFormattedTextField cLine1;
    private javax.swing.JFormattedTextField cLine2;
    private javax.swing.JFormattedTextField cLine3;
    private javax.swing.JFormattedTextField cLine4;
    private javax.swing.JFormattedTextField cLinePP1;
    private javax.swing.JFormattedTextField cLinePP2;
    private javax.swing.JList cList;
    private javax.swing.JLabel cListLabel;
    private javax.swing.JLabel cListLabel1;
    private javax.swing.JFormattedTextField careerA;
    private javax.swing.JFormattedTextField careerG;
    private javax.swing.JFormattedTextField careerP;
    private javax.swing.JFormattedTextField ceilCHK;
    private javax.swing.JFormattedTextField ceilCHK1;
    private javax.swing.JFormattedTextField ceilEND;
    private javax.swing.JFormattedTextField ceilEND1;
    private javax.swing.JFormattedTextField ceilFAC;
    private javax.swing.JFormattedTextField ceilFAC1;
    private javax.swing.JFormattedTextField ceilFIG;
    private javax.swing.JFormattedTextField ceilFIG1;
    private javax.swing.JFormattedTextField ceilHIT;
    private javax.swing.JFormattedTextField ceilHIT1;
    private javax.swing.JFormattedTextField ceilLEA;
    private javax.swing.JFormattedTextField ceilLEA1;
    private javax.swing.JFormattedTextField ceilPEN;
    private javax.swing.JFormattedTextField ceilPEN1;
    private javax.swing.JFormattedTextField ceilPLA;
    private javax.swing.JFormattedTextField ceilPLA1;
    private javax.swing.JFormattedTextField ceilPOS;
    private javax.swing.JFormattedTextField ceilPOS1;
    private javax.swing.JFormattedTextField ceilSHO;
    private javax.swing.JFormattedTextField ceilSHO1;
    private javax.swing.JFormattedTextField ceilSKA;
    private javax.swing.JFormattedTextField ceilSKA1;
    private javax.swing.JFormattedTextField ceilSTK;
    private javax.swing.JFormattedTextField ceilSTK1;
    private javax.swing.JFormattedTextField ceilSTR;
    private javax.swing.JFormattedTextField ceilSTR1;
    private javax.swing.JLabel ceilingLabel;
    private javax.swing.JLabel ceilingLabel1;
    private javax.swing.JLabel ceilingLabel2;
    private javax.swing.JLabel ceilingLabel3;
    private javax.swing.JLabel ceilingLabel4;
    private javax.swing.JLabel ceilingLabel5;
    private javax.swing.JLabel ceilingLabel6;
    private javax.swing.JLabel ceilingLabel7;
    private javax.swing.JLabel chkLabel;
    private javax.swing.JLabel chkLabel1;
    private javax.swing.JFormattedTextField click;
    private javax.swing.JLabel clickLabel;
    private javax.swing.JButton comparePlayerButton;
    private javax.swing.JTextField comparePlayerField1;
    private javax.swing.JTextField comparePlayerField2;
    private javax.swing.JPanel comparePlayersTab;
    private javax.swing.JFormattedTextField compareResult;
    private javax.swing.JLabel conLabel;
    private javax.swing.JLabel conLabel1;
    private javax.swing.JFormattedTextField country;
    private javax.swing.JLabel countryLabel;
    private javax.swing.JButton createLinesButton;
    private javax.swing.JFormattedTextField curCHK;
    private javax.swing.JFormattedTextField curCHK1;
    private javax.swing.JFormattedTextField curDF;
    private javax.swing.JFormattedTextField curDF1;
    private javax.swing.JFormattedTextField curEND;
    private javax.swing.JFormattedTextField curEND1;
    private javax.swing.JFormattedTextField curFAC;
    private javax.swing.JFormattedTextField curFAC1;
    private javax.swing.JFormattedTextField curFIG;
    private javax.swing.JFormattedTextField curFIG1;
    private javax.swing.JFormattedTextField curHIT;
    private javax.swing.JFormattedTextField curHIT1;
    private javax.swing.JFormattedTextField curLEA;
    private javax.swing.JFormattedTextField curLEA1;
    private javax.swing.JFormattedTextField curOA;
    private javax.swing.JFormattedTextField curOA1;
    private javax.swing.JFormattedTextField curOF;
    private javax.swing.JFormattedTextField curOF1;
    private javax.swing.JFormattedTextField curPEN;
    private javax.swing.JFormattedTextField curPEN1;
    private javax.swing.JFormattedTextField curPLA;
    private javax.swing.JFormattedTextField curPLA1;
    private javax.swing.JFormattedTextField curPOS;
    private javax.swing.JFormattedTextField curPOS1;
    private javax.swing.JFormattedTextField curSHO;
    private javax.swing.JFormattedTextField curSHO1;
    private javax.swing.JFormattedTextField curSKA;
    private javax.swing.JFormattedTextField curSKA1;
    private javax.swing.JFormattedTextField curSTK;
    private javax.swing.JFormattedTextField curSTK1;
    private javax.swing.JFormattedTextField curSTR;
    private javax.swing.JFormattedTextField curSTR1;
    private javax.swing.JFormattedTextField curStreakG;
    private javax.swing.JFormattedTextField curStreakGP;
    private javax.swing.JFormattedTextField curStreakP;
    private javax.swing.JList dList;
    private javax.swing.JLabel dListLabel;
    private javax.swing.JLabel dListLabel1;
    private javax.swing.JFormattedTextField dPair2R;
    private javax.swing.JFormattedTextField dPairRPK1;
    private javax.swing.JFormattedTextField dPairRPK2;
    private javax.swing.JFormattedTextField dPairRPP2;
    private javax.swing.JLabel dfLabel;
    private javax.swing.JLabel dfLabel1;
    private javax.swing.JFormattedTextField dpair1L;
    private javax.swing.JFormattedTextField dpair1R;
    private javax.swing.JFormattedTextField dpair2L;
    private javax.swing.JFormattedTextField dpair3L;
    private javax.swing.JFormattedTextField dpair3R;
    private javax.swing.JFormattedTextField dpairLPK1;
    private javax.swing.JFormattedTextField dpairLPK2;
    private javax.swing.JFormattedTextField dpairLPP1;
    private javax.swing.JFormattedTextField dpairLPP2;
    private javax.swing.JFormattedTextField dpairRPP1;
    private javax.swing.JList draftBestAvailable;
    private javax.swing.JList draftCList;
    private javax.swing.JFormattedTextField draftDF;
    private javax.swing.JFormattedTextField draftDF1;
    private javax.swing.JFormattedTextField draftDF2;
    private javax.swing.JFormattedTextField draftDF3;
    private javax.swing.JFormattedTextField draftDF4;
    private javax.swing.JFormattedTextField draftDF5;
    private javax.swing.JLabel draftDLabel;
    private javax.swing.JLabel draftDLabel1;
    private javax.swing.JLabel draftDLabel2;
    private javax.swing.JList draftDList;
    private javax.swing.JList draftGList;
    private javax.swing.JLabel draftHeaderLabel;
    private javax.swing.JLabel draftLabel;
    private javax.swing.JList draftLwList;
    private javax.swing.JFormattedTextField draftOA;
    private javax.swing.JFormattedTextField draftOA1;
    private javax.swing.JFormattedTextField draftOA2;
    private javax.swing.JFormattedTextField draftOA3;
    private javax.swing.JFormattedTextField draftOA4;
    private javax.swing.JFormattedTextField draftOA5;
    private javax.swing.JLabel draftOALabel;
    private javax.swing.JLabel draftOALabel1;
    private javax.swing.JLabel draftOALabel2;
    private javax.swing.JFormattedTextField draftOF;
    private javax.swing.JFormattedTextField draftOF1;
    private javax.swing.JFormattedTextField draftOF2;
    private javax.swing.JFormattedTextField draftOF3;
    private javax.swing.JFormattedTextField draftOF4;
    private javax.swing.JFormattedTextField draftOF5;
    private javax.swing.JLabel draftOFLabel;
    private javax.swing.JLabel draftOFLabel1;
    private javax.swing.JLabel draftOFLabel2;
    private javax.swing.JFormattedTextField draftPDF;
    private javax.swing.JFormattedTextField draftPDF1;
    private javax.swing.JFormattedTextField draftPDF2;
    private javax.swing.JFormattedTextField draftPDF3;
    private javax.swing.JFormattedTextField draftPDF4;
    private javax.swing.JFormattedTextField draftPDF5;
    private javax.swing.JFormattedTextField draftPOA;
    private javax.swing.JFormattedTextField draftPOA1;
    private javax.swing.JFormattedTextField draftPOA2;
    private javax.swing.JFormattedTextField draftPOA3;
    private javax.swing.JFormattedTextField draftPOA4;
    private javax.swing.JFormattedTextField draftPOA5;
    private javax.swing.JFormattedTextField draftPOF;
    private javax.swing.JFormattedTextField draftPOF1;
    private javax.swing.JFormattedTextField draftPOF2;
    private javax.swing.JFormattedTextField draftPOF3;
    private javax.swing.JFormattedTextField draftPOF4;
    private javax.swing.JFormattedTextField draftPOF5;
    private javax.swing.JFormattedTextField draftPos;
    private javax.swing.JLabel draftQueue;
    private javax.swing.JFormattedTextField draftRd;
    private javax.swing.JList draftRwList;
    private javax.swing.JFormattedTextField draftTDF;
    private javax.swing.JFormattedTextField draftTDF1;
    private javax.swing.JFormattedTextField draftTDF2;
    private javax.swing.JFormattedTextField draftTDF3;
    private javax.swing.JFormattedTextField draftTDF4;
    private javax.swing.JFormattedTextField draftTDF5;
    private javax.swing.JFormattedTextField draftTOA;
    private javax.swing.JFormattedTextField draftTOA1;
    private javax.swing.JFormattedTextField draftTOA2;
    private javax.swing.JFormattedTextField draftTOA3;
    private javax.swing.JFormattedTextField draftTOA4;
    private javax.swing.JFormattedTextField draftTOA5;
    private javax.swing.JFormattedTextField draftTOF;
    private javax.swing.JFormattedTextField draftTOF1;
    private javax.swing.JFormattedTextField draftTOF2;
    private javax.swing.JFormattedTextField draftTOF3;
    private javax.swing.JFormattedTextField draftTOF4;
    private javax.swing.JFormattedTextField draftTOF5;
    private javax.swing.JPanel draftTab;
    private javax.swing.JFormattedTextField draftTeam;
    private javax.swing.JLabel draftTeamLabel;
    private javax.swing.JComboBox draftYearList;
    private javax.swing.JFormattedTextField draftYr;
    private javax.swing.JLabel endLabel;
    private javax.swing.JLabel endLabel1;
    private javax.swing.JLabel facLabel;
    private javax.swing.JLabel facLabel1;
    private javax.swing.JMenuItem faq;
    private javax.swing.JFormattedTextField farmDF1;
    private javax.swing.JFormattedTextField farmDF2;
    private javax.swing.JFormattedTextField farmOA1;
    private javax.swing.JFormattedTextField farmOA2;
    private javax.swing.JFormattedTextField farmOF1;
    private javax.swing.JFormattedTextField farmOF2;
    private javax.swing.JFormattedTextField farmSalary;
    private javax.swing.JLabel farmSalaryLabel;
    private javax.swing.JRadioButton farmTeamButton;
    private javax.swing.JLabel figLabel;
    private javax.swing.JLabel figLabel1;
    private javax.swing.JFormattedTextField gBackup;
    private javax.swing.JLabel gLabel;
    private javax.swing.JList gList;
    private javax.swing.JLabel gListLabel;
    private javax.swing.JLabel gListLabel1;
    private javax.swing.JFormattedTextField gStarting;
    private javax.swing.JLabel grdLabel;
    private javax.swing.JLabel grdLabel1;
    private javax.swing.JLabel gwgLabel;
    private javax.swing.JFormattedTextField hand;
    private javax.swing.JLabel handLabel;
    private javax.swing.JFormattedTextField height;
    private javax.swing.JLabel heightLabel;
    private javax.swing.JLabel hitLabel;
    private javax.swing.JLabel hitLabel1;
    private javax.swing.JLabel injLabel;
    private javax.swing.JLabel injLabel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel leaLabel;
    private javax.swing.JLabel leaLabel1;
    private javax.swing.JLabel linesLabel;
    private javax.swing.JLabel linesLabel1;
    private javax.swing.JLabel linesLabel2;
    private javax.swing.JLabel linesLabel3;
    private javax.swing.JLabel linesLabel4;
    private javax.swing.JLabel linesLabel5;
    private javax.swing.JLabel linesTacticsLabel;
    private javax.swing.JFormattedTextField lwLine1;
    private javax.swing.JFormattedTextField lwLine2;
    private javax.swing.JFormattedTextField lwLine3;
    private javax.swing.JFormattedTextField lwLine4;
    private javax.swing.JFormattedTextField lwLinePP1;
    private javax.swing.JFormattedTextField lwLinePP2;
    private javax.swing.JList lwList;
    private javax.swing.JLabel lwListLabel;
    private javax.swing.JLabel lwListLabel1;
    private javax.swing.JFormattedTextField lwPK1;
    private javax.swing.JFormattedTextField lwPK2;
    private javax.swing.JFormattedTextField mA;
    private javax.swing.JFormattedTextField mG;
    private javax.swing.JFormattedTextField mGP;
    private javax.swing.JFormattedTextField mGWG;
    private javax.swing.JFormattedTextField mP;
    private javax.swing.JFormattedTextField mainPOSI;
    private javax.swing.JList myDraftList;
    private javax.swing.JFormattedTextField numPlayers;
    private javax.swing.JFormattedTextField numPlayersDraft;
    private javax.swing.JFormattedTextField numPlayersFarm;
    private javax.swing.JLabel numPlayersLabel;
    private javax.swing.JLabel numPlayersLabel1;
    private javax.swing.JLabel numPlayersLabel2;
    private javax.swing.JLabel numPlayersLabel3;
    private javax.swing.JLabel numPlayersLabel4;
    private javax.swing.JFormattedTextField numPlayersPro;
    private javax.swing.JFormattedTextField numPlayersProsp;
    private javax.swing.JLabel oaLabel;
    private javax.swing.JLabel oaLabel1;
    private javax.swing.JLabel ofLabel;
    private javax.swing.JLabel ofLabel1;
    private javax.swing.JMenuItem openMenu;
    private javax.swing.JLabel pLabel;
    private javax.swing.JLabel penLabel;
    private javax.swing.JLabel penLabel1;
    private javax.swing.JLabel plaLabel;
    private javax.swing.JLabel plaLabel1;
    private javax.swing.JLabel playerID;
    private javax.swing.JLabel playerIcon;
    private javax.swing.JPanel playerPanel;
    private javax.swing.JTabbedPane playerTab;
    private javax.swing.JFormattedTextField playerTypeC1;
    private javax.swing.JFormattedTextField playerTypeC2;
    private javax.swing.JFormattedTextField playerTypeC3;
    private javax.swing.JFormattedTextField playerTypeC4;
    private javax.swing.JFormattedTextField playerTypeP1;
    private javax.swing.JFormattedTextField playerTypeP2;
    private javax.swing.JLabel posLabel;
    private javax.swing.JLabel posLabel1;
    private javax.swing.JFormattedTextField posiC1;
    private javax.swing.JFormattedTextField posiC2;
    private javax.swing.JFormattedTextField posiC3;
    private javax.swing.JFormattedTextField posiC4;
    private javax.swing.JLabel potLabel;
    private javax.swing.JLabel potLabel1;
    private javax.swing.JLabel proDFLabel;
    private javax.swing.JFormattedTextField proDefense;
    private javax.swing.JPanel proListLabel;
    private javax.swing.JFormattedTextField proOA;
    private javax.swing.JLabel proOALabel;
    private javax.swing.JLabel proOFLabel;
    private javax.swing.JFormattedTextField proOffense;
    private javax.swing.JFormattedTextField proSalary;
    private javax.swing.JLabel proSalaryLabel;
    private javax.swing.JRadioButton proTeamButton;
    private javax.swing.JFormattedTextField projCHK1;
    private javax.swing.JFormattedTextField projDF;
    private javax.swing.JFormattedTextField projDF1;
    private javax.swing.JFormattedTextField projFAC1;
    private javax.swing.JFormattedTextField projFIG1;
    private javax.swing.JFormattedTextField projHIT1;
    private javax.swing.JFormattedTextField projOA;
    private javax.swing.JFormattedTextField projOA1;
    private javax.swing.JFormattedTextField projOF;
    private javax.swing.JFormattedTextField projOF1;
    private javax.swing.JFormattedTextField projPLA1;
    private javax.swing.JFormattedTextField projPOS1;
    private javax.swing.JFormattedTextField projSHO1;
    private javax.swing.JFormattedTextField projSKA1;
    private javax.swing.JFormattedTextField projSTK1;
    private javax.swing.JFormattedTextField projSTR1;
    private javax.swing.JRadioButton prospectsButton;
    private javax.swing.JButton queueButton;
    private javax.swing.JFormattedTextField rightsField;
    private javax.swing.JLabel rightsLabel;
    private javax.swing.JFormattedTextField rwLine1;
    private javax.swing.JFormattedTextField rwLine2;
    private javax.swing.JFormattedTextField rwLine3;
    private javax.swing.JFormattedTextField rwLine4;
    private javax.swing.JFormattedTextField rwLinePP1;
    private javax.swing.JFormattedTextField rwLinePP2;
    private javax.swing.JList rwList;
    private javax.swing.JLabel rwListLabel;
    private javax.swing.JLabel rwListLabel1;
    private javax.swing.JFormattedTextField rwPK1;
    private javax.swing.JFormattedTextField rwPK2;
    private javax.swing.JFormattedTextField salaryAmt;
    private javax.swing.JFormattedTextField salaryAmt1;
    private javax.swing.JFormattedTextField salaryAmtConsidering;
    private javax.swing.JLabel salaryAmtLabel;
    private javax.swing.JLabel salaryAmtLabel1;
    private javax.swing.JLabel salaryAmtLabelConsidering;
    private javax.swing.JFormattedTextField salaryYr;
    private javax.swing.JFormattedTextField salaryYr1;
    private javax.swing.JFormattedTextField salaryYrConsidering;
    private javax.swing.JLabel salaryYrLabel;
    private javax.swing.JLabel salaryYrLabel1;
    private javax.swing.JLabel salaryYrLabelConsidering;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton searchPlayer;
    private javax.swing.JLabel shoLabel;
    private javax.swing.JLabel shoLabel1;
    private javax.swing.JLabel shoLabel2;
    private javax.swing.JLabel similarPlayerLabel;
    private javax.swing.JList similarPlayerList;
    private javax.swing.JLabel skaLabel;
    private javax.swing.JLabel skaLabel1;
    private javax.swing.JFormattedTextField status;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel stkLabel;
    private javax.swing.JLabel stkLabel1;
    private javax.swing.JLabel strLabel;
    private javax.swing.JLabel strLabel1;
    private javax.swing.JLabel teamIcon;
    private javax.swing.JButton teamSearchButton;
    private javax.swing.JTextField teamSearchField;
    private javax.swing.JFormattedTextField timeLine1;
    private javax.swing.JFormattedTextField timeLine2;
    private javax.swing.JFormattedTextField timeLine3;
    private javax.swing.JFormattedTextField timeLine4;
    private javax.swing.JFormattedTextField timePK1;
    private javax.swing.JFormattedTextField timePK2;
    private javax.swing.JFormattedTextField timePP1;
    private javax.swing.JFormattedTextField timePP2;
    private javax.swing.JFormattedTextField trainDF;
    private javax.swing.JFormattedTextField trainDF1;
    private javax.swing.JFormattedTextField trainOA;
    private javax.swing.JFormattedTextField trainOA1;
    private javax.swing.JFormattedTextField trainOF;
    private javax.swing.JFormattedTextField trainOF1;
    private javax.swing.JFormattedTextField twoWay;
    private javax.swing.JLabel twoWayLabel;
    private javax.swing.JFormattedTextField wA;
    private javax.swing.JFormattedTextField wG;
    private javax.swing.JFormattedTextField wGP;
    private javax.swing.JFormattedTextField wGWG;
    private javax.swing.JFormattedTextField wP;
    private javax.swing.JLabel weeklyLabel;
    private javax.swing.JLabel weeklyLabel1;
    private javax.swing.JLabel weeklyLabel2;
    private javax.swing.JLabel weeklyLabel3;
    private javax.swing.JLabel weeklyLabel4;
    private javax.swing.JFormattedTextField weight;
    private javax.swing.JLabel weightLabel;
    private javax.swing.JMenuItem writePlayersFile;
    // End of variables declaration//GEN-END:variables
}
