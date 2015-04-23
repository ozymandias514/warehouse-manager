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

public class UnitFillScreenUITest extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public UnitFillScreenUITest() {
		super(project.warehouse_manager.Main.class);
	}

	/**
	 * Main test method.
	 */
	public void testUnitFillScreenUI() throws Exception {
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
		ui.click(new JButtonLocator("Unit Options"));
		ui.wait(new WindowDisposedCondition("Warehouse Management"));
		ui.wait(new WindowShowingCondition("Warehouse"));
		ui.click(new JButtonLocator("Fill Unit"));
		ui.wait(new WindowDisposedCondition("Warehouse"));
		ui.wait(new WindowShowingCondition("Warehouse"));
		ui.click(new JButtonLocator("Clear fields"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.click(new JTextComponentLocator(JTextField.class, 0,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("3");
		ui.click(new JTextComponentLocator(JTextField.class, 1,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("6");
		ui.click(new JTextComponentLocator(JTextField.class, 2,
				new SwingWidgetLocator(JPanel.class)));
		ui.enterText("large amount of wine");
		ui.click(new NamedWidgetLocator("Spinner.nextButton"));
		ui.click(new NamedWidgetLocator("Spinner.nextButton"));
		ui.click(new NamedWidgetLocator("Spinner.nextButton"));
		ui.click(new NamedWidgetLocator("Spinner.nextButton"));
		ui.click(new NamedWidgetLocator("Spinner.nextButton"));
		ui.click(new JButtonLocator("Submit"));
		ui.wait(new WindowShowingCondition("Information"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Information"));
		ui.wait(new WindowDisposedCondition("Warehouse"));
	}

}