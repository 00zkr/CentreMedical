/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import service.MailService;

/**
 *
 * @author User
 */
public class MailTest {
    public static void main(String[] args) {
        

        boolean res = MailService.sendEmail(
            "zakariarhendour@gmail.com",
            "Test passed",
            "u r da goat"
        );

        if (res) {
            System.out.println("yes");
        } else {
            System.out.println("failed");
        }
    }
}