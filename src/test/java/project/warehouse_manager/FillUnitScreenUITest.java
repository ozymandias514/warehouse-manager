package project.warehouse_manager;

import com.windowtester.runtime.swing.locator.LabeledTextLocator;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swing.locator.JButtonLocator;
import com.windowtester.runtime.swing.condition.WindowShowingCondition;
import com.windowtester.runtime.swing.locator.NamedWidgetLocator;
import com.windowtester.runtime.swing.condition.WindowDisposedCondition;
import com.windowtester.runtime.swing.locator.JTextComponentLocator;
import javax.swing.JTextField;
import com.windowtester.runtime.swing.SwingWidgetLocator;
import javax.swing.JPanel;

public class FillUnitScreenUITest extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public FillUnitScreenUITest() {
		super(project.warehouse_manager.Main.class);
	}

	/**
	 * Main test method.
	 */
	public void testFillUnitScreenUI() throws Exception {
		IUIContext ui = getUI();
		ui.click(new LabeledTextLocator("Username"));
		ui.enterText("jfgonzal");
		ui.click(new LabeledTextLocator("Password"));
		ui.enterText("pass");
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowShowingCondition("Information"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Information"));
		ui.wait(new WindowDisposedCondition("Warehouse Management"));
		ui.wait(new WindowShowingCondition("Warehouse Management"));
		ui.click(new JButtonLocator("Unit Options"));
		ui.wait(new WindowDisposedCondition("Warehouse Management"));
		ui.wait(new WindowShowingCondition("Warehouse"));
		ui.click(new JButtonLocator("Fill Unit"));
		ui.wait(new WindowDisposedCondition("Warehouse"));
		ui.wait(new WindowShowingCondition("Warehouse"));
		ui.click(new JTextComponentLocator(JTextField.class, 0,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("3");
		ui.click(new NamedWidgetLocator("Spinner.nextButton"));
		ui.click(new NamedWidgetLocator("Spinner.nextButton"));
		ui.enterText("5");
		ui.enterText("bag of  chocolate");
		ui.click(new JButtonLocator("Submit"));
		ui.wait(new WindowShowingCondition("Information"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Information"));
		ui.wait(new WindowDisposedCondition("Warehouse"));
	}

}