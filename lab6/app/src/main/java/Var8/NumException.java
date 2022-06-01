/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Var8;

/**
 *
 * @author dunke
 */
public class NumException extends Exception{
    
    String message;
        
        NumException(String except_message) 
        {
            this.message = except_message;
        }
        
        @Override
        public String toString()
        {
            return ("NumException trigger: " + this.message);
        }
}
