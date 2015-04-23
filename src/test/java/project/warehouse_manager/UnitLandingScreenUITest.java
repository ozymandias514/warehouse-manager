package project.warehouse_manager;

import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.IUIContext;
import com.windowtester.runtime.swing.locator.LabeledTextLocator;
import com.windowtester.runtime.swing.locator.JButtonLocator;
import com.windowtester.runtime.swing.condition.WindowShowingCondition;
import com.windowtester.runtime.swing.condition.WindowDisposedCondition;

public class UnitLandingScreenUITest extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public UnitLandingScreenUITest() {
		super(project.warehouse_manager.Main.class);
	}

	/**
	 * Main test method.
	 */
	public void testUnitLandingScreenUI() throws Exception {
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
		ui.enterText("1");
		ui.click(new JButtonLocator("Find by unit Id"));
		ui.click(new JButtonLocator("Find By customer id"));
		ui.click(new JButtonLocator("get data"));
		ui.click(new JButtonLocator("find small vacant"));
		ui.click(new JButtonLocator("find large vacant"));
		ui.wait(new WindowDisposedCondition("Warehouse"));
	}

}