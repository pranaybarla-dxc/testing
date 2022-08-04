package ldap_connection;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.ModificationItem;



public class addAttributes {
	public void addEntry() {
		Properties properties = new Properties();
		properties.put(Context.INITIAL_CONTEXT_FACTORY,
		"com.sun.jndi.ldap.LdapCtxFactory");
		properties.put(Context.PROVIDER_URL, "ldap://localhost:10389");
		properties.put(Context.SECURITY_PRINCIPAL, "uid=admin,ou=system");
		properties.put(Context.SECURITY_CREDENTIALS, "secret");
		try {
		DirContext context = new InitialDirContext(properties);
		Attributes attributes = context
		.getAttributes("cn=Jenny,ou=users,ou=system");		
		Attribute attribute = new BasicAttribute("homePhone", "7777777");
		ModificationItem[] item = new ModificationItem[1];
		item[0] = new ModificationItem(DirContext.ADD_ATTRIBUTE, attribute);
		attributes.put(attribute);
		context.modifyAttributes(
				"cn=Jenny,ou=users,ou=system", item);
				System.out.println("After addition of new attribute..");
				Attributes attributes1 = context
				.getAttributes("cn=Jenny,ou=users,ou=system");
				//displayAttributes(attributes1);
		} catch (NamingException e) {
			e.printStackTrace();
			}
			}



	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addAttributes app = new addAttributes();
		
		app.addEntry();

	}

}
