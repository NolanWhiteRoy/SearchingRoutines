package binarysearch;

import java.util.*;
import java.awt.Color;
import java.io.*;

public class SearchingRoutinesUI extends javax.swing.JFrame {

    // Global Variable decleration. 
    List<Object> bookList = new ArrayList<>();

    //Buffered reader decleration. 
    BufferedReader br;

    public SearchingRoutinesUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        exitBtn = new javax.swing.JButton();
        titleLbl = new javax.swing.JLabel();
        instructionsLbl = new javax.swing.JLabel();
        lastNameLbl = new javax.swing.JLabel();
        firstNameLbl = new javax.swing.JLabel();
        refNumTxtField = new javax.swing.JTextField();
        findBookBtn = new javax.swing.JButton();
        linearSearchOutputTxtField = new javax.swing.JTextField();
        binarySearchOutputTxtField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        exitBtn.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        exitBtn.setText("Exit");
        exitBtn.setFocusCycleRoot(true);
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });

        titleLbl.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        titleLbl.setText("CHILDREN'S CLASSICS ");

        instructionsLbl.setFont(new java.awt.Font("Trebuchet MS", 1, 13)); // NOI18N
        instructionsLbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        instructionsLbl.setText("ENTER THE REFERNCE NUMBER :");

        lastNameLbl.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        lastNameLbl.setText("BINARY SEARCH:");

        firstNameLbl.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        firstNameLbl.setText("LINEAR SEARCH:");

        refNumTxtField.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N

        findBookBtn.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N
        findBookBtn.setText("FIND BOOK");
        findBookBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findBookBtnActionPerformed(evt);
            }
        });

        linearSearchOutputTxtField.setEditable(false);
        linearSearchOutputTxtField.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N

        binarySearchOutputTxtField.setEditable(false);
        binarySearchOutputTxtField.setFont(new java.awt.Font("Trebuchet MS", 0, 13)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(exitBtn)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(instructionsLbl)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(findBookBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(refNumTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lastNameLbl)
                            .addComponent(firstNameLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linearSearchOutputTxtField)
                            .addComponent(binarySearchOutputTxtField))))
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleLbl)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(exitBtn)
                .addGap(18, 18, 18)
                .addComponent(titleLbl)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(instructionsLbl)
                    .addComponent(refNumTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(findBookBtn)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(firstNameLbl)
                    .addComponent(linearSearchOutputTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lastNameLbl)
                    .addComponent(binarySearchOutputTxtField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // Exit system.
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

    private void findBookBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findBookBtnActionPerformed
        try {

            br = new BufferedReader(new FileReader("BookList.txt"));
            String word;

            while ((word = br.readLine()) != null) {

                String bookTitle = word;
                int referenceNumber = Integer.parseInt(word);
                
                // Add book to book class. 
                bookList.add(new book(referenceNumber, bookTitle));

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_findBookBtnActionPerformed

    // Code for linear search. 
    static public Boolean sortedLinearSearch(String[] A, String B) {
        for (int k = 0; k < A.length; k++) {
            int compare = A[k].compareTo(B);
            if (compare == 0) {
                return true;
            }
            if (compare > 0) {
                return false;
            }
        }
        return false;
    }

    public static Boolean binarySearch(String[] A, int left, int right, String V) {

        int middle;
        //numSearches++;
        
        if (left > right) {
            return false;
        }

        middle = (left + right) / 2;
        int compare = V.compareTo(A[middle]);
        if (compare == 0) {
            return true;
        }
        if (compare < 0) {
            return binarySearch(A, left, middle - 1, V);
        } else {
            return binarySearch(A, middle + 1, right, V);
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchingRoutinesUI().setVisible(true);
            }
        });
    }

    class book {

        int referenceNumber;
        String bookTitle;

        book(int _referenceNumber, String _bookTitle) {
            referenceNumber = _referenceNumber;
            bookTitle = _bookTitle;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField binarySearchOutputTxtField;
    private javax.swing.JButton exitBtn;
    private javax.swing.JButton findBookBtn;
    private javax.swing.JLabel firstNameLbl;
    private javax.swing.JLabel instructionsLbl;
    private javax.swing.JLabel lastNameLbl;
    private javax.swing.JTextField linearSearchOutputTxtField;
    private javax.swing.JTextField refNumTxtField;
    private javax.swing.JLabel titleLbl;
    // End of variables declaration//GEN-END:variables
}
