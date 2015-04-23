package project.warehouse_manager;

import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swing.locator.LabeledTextLocator;
import com.windowtester.runtime.swing.locator.JButtonLocator;
import com.windowtester.runtime.swing.condition.WindowShowingCondition;
import com.windowtester.runtime.swing.condition.WindowDisposedCondition;
import com.windowtester.runtime.swing.locator.JTextComponentLocator;
import javax.swing.JTextField;
import com.windowtester.runtime.swing.SwingWidgetLocator;
import javax.swing.JPanel;

public class CustomerAlterScreenUITest extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public CustomerAlterScreenUITest() {
		super(project.warehouse_manager.Main.class);
	}

	/**
	 * Main test method.
	 */
	public void testCustomerAlterScreenUI() throws Exception {
		IUIContext ui = getUI();
		ui.enterText("kirk");
		ui.click(new LabeledTextLocator("Password"));
		ui.enterText("pass");
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowShowingCondition("Information"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Information"));
		ui.wait(new WindowDisposedCondition("Warehouse Management"));
		ui.wait(new WindowShowingCondition("Warehouse Management"));
		ui.click(new JButtonLocator("Customer Options"));
		ui.wait(new WindowDisposedCondition("Warehouse Management"));
		ui.wait(new WindowShowingCondition("Customer page"));
		ui.click(new JButtonLocator("Alter records"));
		ui.wait(new WindowDisposedCondition("Customer page"));
		ui.wait(new WindowShowingCondition("Customer Alter Page"));
		ui.click(new JButtonLocator("Clear Fields"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JTextComponentLocator(JTextField.class, 0,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("1");
		ui.click(new JTextComponentLocator(JTextField.class, 1,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("jon");
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
		ui.enterText("1");
		ui.click(new JTextComponentLocator(JTextField.class, 1,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("doe");
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
		ui.enterText("1");
		ui.click(new JTextComponentLocator(JTextField.class, 1,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("jdoe@gmail.com");
		ui.click(new JButtonLocator("Change Email"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.wait(new WindowDisposedCondition("Customer Alter Page"));
	}

}