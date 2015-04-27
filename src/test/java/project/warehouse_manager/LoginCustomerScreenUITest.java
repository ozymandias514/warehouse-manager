package project.warehouse_manager;

import com.windowtester.runtime.swing.locator.JButtonLocator;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swing.condition.WindowShowingCondition;
import com.windowtester.runtime.swing.condition.WindowDisposedCondition;
import com.windowtester.runtime.swing.locator.LabeledTextLocator;
import com.windowtester.runtime.swing.locator.JTextComponentLocator;
import javax.swing.JTextField;
import com.windowtester.runtime.swing.SwingWidgetLocator;
import javax.swing.JPanel;

public class LoginCustomerScreenUITest extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public LoginCustomerScreenUITest() {
		super(project.warehouse_manager.Main.class);
	}

	/**
	 * Main test method.
	 */
	public void testLoginCustomerScreenUI() throws Exception {
		IUIContext ui = getUI();
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new LabeledTextLocator("Username"));
		ui.enterText("j");
		ui.click(new LabeledTextLocator("Password"));
		ui.enterText("p");
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowShowingCondition("Information"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Information"));
		ui.click(new LabeledTextLocator("Username"));
		ui.enterText("");
		ui.enterText("fgonzal");
		ui.click(new LabeledTextLocator("Password"));
		ui.enterText("");
		ui.enterText("ass");
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowShowingCondition("Information"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Information"));
		ui.click(new JButtonLocator("Customer Options"));
		ui.wait(new WindowDisposedCondition("Warehouse Management"));
		ui.wait(new WindowShowingCondition("Customer page"));
		ui.click(new JButtonLocator("Find By Email"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JTextComponentLocator(JTextField.class));
		ui.enterText("jdoe@gmail.com");
		ui.click(new JButtonLocator("Find By Email"));
		ui.click(new JButtonLocator("Find By Id"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JButtonLocator("Clear Fields"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		
		ui.click(new JTextComponentLocator(JTextField.class));
		ui.enterText("1");
		ui.click(new JButtonLocator("Find By Id"));
		ui.click(new JButtonLocator("Clear Fields"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		
		ui.click(new JTextComponentLocator(JTextField.class));
		ui.enterText("20");
		ui.click(new JButtonLocator("Find By Id"));
		ui.click(new JButtonLocator("Clear Fields"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		
		ui.click(new JTextComponentLocator(JTextField.class));
		ui.enterText("5");
		ui.click(new JButtonLocator("Find By Id"));
		ui.click(new JButtonLocator("Clear Fields"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JButtonLocator("Find By Id"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JButtonLocator("display List"));
		ui.click(new JButtonLocator("Alter records"));
		ui.wait(new WindowDisposedCondition("Customer page"));
		ui.wait(new WindowShowingCondition("Customer Alter Page"));
		ui.click(new JTextComponentLocator(JTextField.class, 1,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("peter");
		ui.click(new JButtonLocator("Change First Name"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JButtonLocator("Change Last Name"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JButtonLocator("Change Email"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JButtonLocator("Clear Fields"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JButtonLocator("Change First Name"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JButtonLocator("Change Last Name"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JButtonLocator("Change Email"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JTextComponentLocator(JTextField.class, 0,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("12");
		ui.click(new JTextComponentLocator(JTextField.class, 1,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("patrick");
		ui.click(new JButtonLocator("Change First Name"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JButtonLocator("Clear Fields"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JTextComponentLocator(JTextField.class, 0,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("12");
		ui.click(new JTextComponentLocator(JTextField.class, 1,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("devora");
		ui.click(new JButtonLocator("Change Last Name"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JButtonLocator("Clear Fields"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JTextComponentLocator(JTextField.class, 0,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("12");
		ui.click(new JTextComponentLocator(JTextField.class, 1,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("pdev@gmail.com");
		ui.click(new JButtonLocator("Change Email"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JButtonLocator("go back"));
		ui.wait(new WindowDisposedCondition("Customer Alter Page"));
		ui.wait(new WindowShowingCondition("Customer page"));
		ui.click(new JButtonLocator("Add/Delete customer"));
		ui.wait(new WindowDisposedCondition("Customer page"));
		ui.wait(new WindowShowingCondition("customer add and remove"));
		ui.click(new JButtonLocator("Clear All"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JButtonLocator("add customer"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JTextComponentLocator(JTextField.class, 0,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("dio");
		ui.click(new JTextComponentLocator(JTextField.class, 1,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("joestar");
		ui.click(new JTextComponentLocator(JTextField.class, 2,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("djoe@gmail.com");
		ui.click(new JButtonLocator("add customer"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JButtonLocator("delete customer"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JTextComponentLocator(JTextField.class, 4,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("djoe@gmail.com");
		ui.click(new JButtonLocator("delete customer"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JButtonLocator("Clear All"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JTextComponentLocator(JTextField.class, 3,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("ID");
		ui.click(new JButtonLocator("delete customer"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JButtonLocator("Clear All"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JTextComponentLocator(JTextField.class, 3,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("9000");
		ui.click(new JButtonLocator("delete customer"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JButtonLocator("Clear All"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JTextComponentLocator(JTextField.class, 3,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("9001");
		ui.click(new JButtonLocator("delete customer"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JButtonLocator("go back"));
		ui.click(new JButtonLocator("Go Back"));
		ui.wait(new WindowDisposedCondition("Customer page"));
	}

}