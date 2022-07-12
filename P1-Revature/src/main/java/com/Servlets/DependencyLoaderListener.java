package com.Servlets;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class DependencyLoaderListener implements ServletContextListener {



        @Override
        public void contextInitialized(ServletContextEvent servletContextEvent) {



            System.out.println("contextInitialized() - This method in the DependencyLoaderListener has been run.");

        }

        @Override
        public void contextDestroyed(ServletContextEvent servletContextEvent) {


            System.out.println("contextDestroyed() - This method in the DependencyLoaderListener has been run.");

        }








}
