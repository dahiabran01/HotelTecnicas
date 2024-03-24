/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hotel;

public class HotelMain {

    public static void main(String[] args) {
      Menu menu = new Menu("Midnight Memories", "Cra14,#12-11", "3216549878");
      var hotelInfo=menu.toString();
        System.out.println(hotelInfo);
              menu.getMenu();
              

        
    }

}
