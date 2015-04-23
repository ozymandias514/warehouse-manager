package project.warehouse_manager;

import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swing.locator.LabeledTextLocator;
import com.windowtester.runtime.swing.locator.JButtonLocator;
import com.windowtester.runtime.swing.condition.WindowShowingCondition;
import com.windowtester.runtime.swing.condition.WindowDisposedCondition;

public class UnitLandingRemoveUITest extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public UnitLandingRemoveUITest() {
		super(project.warehouse_manager.Main.class);
	}

	/**
	 * Main test method.
	 */
	public void testUnitLandingRemoveUI() throws Exception {
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
		ui.enterText("3");
		ui.click(new JButtonLocator("remove"));
		ui.wait(new WindowShowingCondition("Solution"));
		ui.click(new JButtonLocator("OK"));
		ui.wait(new WindowDisposedCondition("Solution"));
		ui.wait(new WindowDisposedCondition("Warehouse"));
	}

}