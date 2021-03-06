package Ex22_3.Ex22_3_3;

public class MainProject
{
  public static void main(String[] args)
  {
    Project project1 = new Project("Project 1", MultitonKey.dk);
    project1.addGlossaryItem("Client",
        "The client part of " + "client/server application.");
    project1
        .addGlossaryItem("User", "End user in form of a doctor or a nurse.");
    project1.addGlossaryItem("Account",
        "A location on the server application storing username, "
            + "password and phone number.");
    System.out.println("Project 1: Definition for Client: " + project1
        .getDefinition("Client"));
    System.out.println(project1);



    Project project2 = new Project("Project 2", MultitonKey.dk);
    project2.addGlossaryItem("Client",
        "The client part of " + "client/server application.");
    project2
        .addGlossaryItem("User", "End user in form of a doctor or a nurse.");

    System.out.println("Project 2: Definition for Client: " + project2
        .getDefinition("Client"));
    System.out.println(project2);

/* OUTPUT:
Project 1: Definition for Client: The client part of a client/server application.
Project: Project 1
- Client: "The client part of a client/server application."
- User: "End user in form of a doctor or a nurse."
- Account: "A location on the server application storing username, password and phone number."
*/
  }
}
