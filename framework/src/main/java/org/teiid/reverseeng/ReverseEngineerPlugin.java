/*
 * JBoss, Home of Professional Open Source.
 * See the COPYRIGHT.txt file distributed with this work for information
 * regarding copyright ownership.  Some portions may be licensed
 * to Red Hat, Inc. under one or more contributor license agreements.
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA
 * 02110-1301 USA.
 */

package org.teiid.reverseeng;

import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.*;
import org.apache.log4j.PropertyConfigurator;
import org.teiid.core.BundleUtil;
import org.teiid.core.util.PropertiesUtils;

public class ReverseEngineerPlugin { 
 	
    public static final String PLUGIN_ID = ReverseEngineerPlugin.class.getPackage().getName();
    
    public static final Category LOGGER = Category.getInstance(ReverseEngineerPlugin.class);
    static final String LOG_PROPERTIES_FILE = "log4j.properties";

    /**
     * Provides access to the plugin's log and to it's resources.
     */
    public static final BundleUtil Util = new BundleUtil(PLUGIN_ID, PLUGIN_ID + ".i18n", ResourceBundle.getBundle(PLUGIN_ID + ".i18n")); //$NON-NLS-1$ //$NON-NLS-2$

    static {
    	initializeLogger();
    }
    
    public static enum Event implements BundleUtil.Event{
    	NO_METADATA,
    	POJO_DOESNT_EXIST
    }
    
    private static void initializeLogger()
    {
      Properties logProperties = new Properties();
   
      try
      {
    	  logProperties =  PropertiesUtils.loadAsResource(ReverseEngineerPlugin.class, LOG_PROPERTIES_FILE);
    	
        // load our log4j properties / configuration file
//        logProperties.load(new FileInputStream(LOG_PROPERTIES_FILE));
        PropertyConfigurator.configure(logProperties);
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Logging initialized.");
      }
      catch(IOException e)
      {
    	  e.printStackTrace();
        throw new RuntimeException("Unable to load logging property " + LOG_PROPERTIES_FILE);
      }
    }
    
}
