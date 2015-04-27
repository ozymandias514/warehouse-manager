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
import com.windowtester.runtime.swing.locator.NamedWidgetLocator;

public class UnitScreenUITest extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public UnitScreenUITest() {
		super(project.warehouse_manager.Main.class);
	}

	/**
	 * Main test method.
	 */
	public void testUnitScreenUI() throws Exception {
		IUIContext ui = getUI();
		ui.enterText("kirk");
		ui.click(new LabeledTextLocator("Password"));
		ui.enterText("pass");
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowShowingCondition("Information"));
		ui.click(new JButtonLocator("OK"));
		ui.click(new JButtonLocator("Unit Options"));
		ui.wait(new WindowDisposedCondition("Warehouse Management"));
		ui.wait(new WindowShowingCondition("Warehouse"));
		ui.click(new JButtonLocator("Find by unit Id"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JButtonLocator("Find By customer id"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JButtonLocator("find small vacant"));
		ui.click(new JButtonLocator("find large vacant"));
		ui.click(new JTextComponentLocator(JTextField.class));
		ui.enterText("pizza");
		ui.click(new JButtonLocator("Find by unit Id"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JButtonLocator("Find By customer id"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JButtonLocator("get data"));
		ui.click(new JButtonLocator("Clear All"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JTextComponentLocator(JTextField.class));
		ui.enterText("1");
		ui.click(new JButtonLocator("Find by unit Id"));
		ui.click(new JButtonLocator("Find By customer id"));
		ui.click(new JButtonLocator("alter"));
		ui.click(new JButtonLocator("Change Description"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JButtonLocator("Change pickup"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JButtonLocator("Clear Fields"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JTextComponentLocator(JTextField.class, 1,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("2");
		ui.click(new JButtonLocator("Change Description"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JTextComponentLocator(JTextField.class, 0,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("party time");
		ui.click(new JButtonLocator("Change Description"));
		ui.wait(new WindowShowingCondition("Information"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Information"));
		ui.click(new JButtonLocator("Change pickup"));
		ui.wait(new WindowShowingCondition("Information"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Information"));
		ui.click(new NamedWidgetLocator("Spinner.nextButton"));
		ui.click(new JButtonLocator("Change pickup"));
		ui.wait(new WindowShowingCondition("Information"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Information"));
		ui.click(new JButtonLocator("go back"));
		ui.click(new JButtonLocator("Fill Unit"));
		ui.click(new JButtonLocator("Submit"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JButtonLocator("Clear fields"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JTextComponentLocator(JTextField.class, 0,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("17");
		ui.click(new JTextComponentLocator(JTextField.class, 1,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("5");
		ui.click(new JTextComponentLocator(JTextField.class, 2,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("small bag");
		ui.click(new JButtonLocator("Submit"));
		ui.wait(new WindowShowingCondition("Information"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Information"));
		ui.click(new JButtonLocator("Go back"));
		ui.click(new JButtonLocator("remove"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JTextComponentLocator(JTextField.class));
		ui.enterText("pizza");
		ui.click(new JButtonLocator("remove"));
		ui.wait(new WindowShowingCondition("Error"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Error"));
		ui.click(new JButtonLocator("Clear All"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JTextComponentLocator(JTextField.class));
		ui.enterText("17");
		ui.click(new JButtonLocator("remove"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		
	}

}