# A trivial ModeShape example

This repository contains a very simple application that uses Maven 3 for its build system and that shows how to embed ModeShape into the application.

To use, simply clone the repository:

    $ git clone git://github.com/rhauch/modeshape-embedded-example.git
    $ cd modeshape-embedded-example

Be sure that you have Maven 3 installed; if not, see [this ModeShape community article](http://community.jboss.org/wiki/ModeShapeandMaven) for help on how to install it. Once installed, simply build the project:

    $ mvn clean install

This will compile everything, run the unit test (that runs the command line application), and install the JARs into your local Maven repository.

Please feel free to fork this repository and create your own application, or use this as a guide for building your own ModeShape application. 

# Problems or questions?

If you have any questions or problems, post a question in our [user forum](http://community.jboss.org/en/modeshape) or hop into our [IRC chat room](http://www.jboss.org/modeshape/chat) and talk our community of contributors and users.