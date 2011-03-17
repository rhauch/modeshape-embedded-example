/*
 * ModeShape (http://www.modeshape.org)
 * See the COPYRIGHT.txt file distributed with this work for information
 * regarding copyright ownership.  Some portions may be licensed
 * to Red Hat, Inc. under one or more contributor license agreements.
 * See the AUTHORS.txt file in the distribution for a full listing of 
 * individual contributors.
 *
 * ModeShape is free software. Unless otherwise indicated, all code in ModeShape
 * is licensed to you under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 * 
 * ModeShape is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.modeshape.example.embedded;

import java.io.IOException;
import java.net.URL;
import javax.jcr.Repository;
import javax.jcr.Session;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import org.modeshape.jcr.JcrConfiguration;
import org.modeshape.jcr.JcrEngine;
import org.xml.sax.SAXException;

public class ModeShapeExample {
	
	public static void main( String[] argv ) {
		
		// Load the configuration via the classloader (can also use path to a file)...
		JcrConfiguration config = new JcrConfiguration();
        try {
            URL url = ModeShapeExample.class.getClassLoader().getResource("modeshape-config.xml");       
		    config.loadFrom(url);
        } catch ( SAXException e ) {
            System.err.println("Failed to read the configuration file");
        } catch ( IOException e ) {
            System.err.println("Failed to load the configuration file");
        }
		
		// Create and start the engine ...
        JcrEngine engine = config.build();
        if ( engine.getProblems().hasErrors() ) {
            System.err.println("Problems starting the engine.");
            System.err.println(engine.getProblems());
            System.exit(-1);
        }

        // Start the engine
        engine.start();

        Repository repository = null;
        Session session = null;
        try {
	        // Get the repository
            repository = engine.getRepository("My repository");

		    // Create a session ...
            session = repository.login("default");

            // Get the root node ...
            Node root = session.getRootNode();
		
            System.out.println("Found the root node in the \"" + session.getWorkspace().getName() + "\" workspace");
        } catch ( RepositoryException e ) {
            System.err.println("Failed to load the configuration file");
        } finally {
            if ( session != null ) session.logout();
            if ( engine != null ) engine.shutdown();
        }

	}
}
