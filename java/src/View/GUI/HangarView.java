/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package View.GUI;

import java.util.ArrayList;

import java.awt.Component;

import deepspace.WeaponToUI;
import deepspace.ShieldToUI;
import deepspace.HangarToUI;


/**
 *
 * @author yabir
 */
public class HangarView extends javax.swing.JPanel {

    /**
     * Creates new form HangarView
     */
    public HangarView() {
        initComponents();
    }
    
    public void setHangar(HangarToUI h){
        String title = "Hangar de " + h.getMaxElements() + " elementos";
        hangarPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,0,0)),title));
        items.removeAll();
        
        WeaponView weaponView;
        for(WeaponToUI w: h.getWeapons()){
            weaponView = new WeaponView();
            weaponView.setWeapon(w);
            items.add(weaponView);
        }
        
        ShieldView shieldView;
        for(ShieldToUI w: h.getShieldBoosters()){
            shieldView = new ShieldView();
            shieldView.setShield(w);
            items.add(shieldView);
        }
        
        repaint();
        revalidate();
    }
    
    public ArrayList<Integer> getSelected(){
        ArrayList<Integer> selected = new ArrayList<>();
        int pos = 0;
        for(Component c: items.getComponents()){
            if( ((CombatElement) c).isSelected()){
                selected.add(pos);
            }
            pos += 1;
        }
        return selected;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        hangarPanel = new javax.swing.JScrollPane();
        items = new javax.swing.JPanel();

        setBorder(null);

        items.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        hangarPanel.setViewportView(items);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(hangarPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hangarPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane hangarPanel;
    private javax.swing.JPanel items;
    // End of variables declaration//GEN-END:variables
}
