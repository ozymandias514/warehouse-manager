package project.warehouse_manager;

import com.windowtester.runtime.swing.locator.NamedWidgetLocator;
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

public class CustomerAddScreenUITest extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public CustomerAddScreenUITest() {
		super(project.warehouse_manager.Main.class);
	}

	/**
	 * Main test method.
	 */
	public void testCustomerAddScreenUI() throws Exception {
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
		ui.click(new JButtonLocator("Add/Delete customer"));
		ui.wait(new WindowDisposedCondition("Customer page"));
		ui.wait(new WindowShowingCondition("customer add and remove"));
		ui.click(new JButtonLocator("Clear All"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JTextComponentLocator(JTextField.class, 0,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("test");
		ui.click(new JTextComponentLocator(JTextField.class, 1,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("tester");
		ui.click(new JTextComponentLocator(JTextField.class, 2,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("ttes@gmail.com");
		ui.click(new JButtonLocator("add customer"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JButtonLocator("Clear All"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JButtonLocator("go back"));
		ui.wait(new WindowDisposedCondition("customer add and remove"));
	}

}