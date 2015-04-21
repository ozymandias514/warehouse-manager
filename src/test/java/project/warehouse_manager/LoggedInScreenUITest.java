package project.warehouse_manager;

import com.windowtester.runtime.swing.locator.LabeledTextLocator;
import com.windowtester.runtime.swing.UITestCaseSwing;
import com.windowtester.runtime.IUIContext;
import java.awt.event.KeyEvent;
import com.windowtester.runtime.WT;
import com.windowtester.runtime.swing.locator.JButtonLocator;
import com.windowtester.runtime.swing.condition.WindowShowingCondition;
import com.windowtester.runtime.swing.condition.WindowDisposedCondition;

public class LoggedInScreenUITest extends UITestCaseSwing {

	/**
	 * Create an Instance
	 */
	public LoggedInScreenUITest() {
		super(project.warehouse_manager.Main.class);
	}

	/**
	 * Main test method.
	 */
	public void testLoggedInScreenUI() throws Exception {
		IUIContext ui = getUI();
		ui.click(new LabeledTextLocator("Username"));
		ui.enterText("jfgonzal");
		ui.keyClick(KeyEvent.VK_TAB);
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
		ui.click(new JButtonLocator("go back"));
		ui.wait(new WindowDisposedCondition("Warehouse"));
		ui.wait(new WindowShowingCondition("Warehouse Management"));
		ui.click(new JButtonLocator("Admin Panel"));
		ui.wait(new WindowDisposedCondition("Warehouse Management"));
		ui.wait(new WindowShowingCondition("Admin Page"));
		ui.click(new JButtonLocator("Go Back"));
		ui.wait(new WindowDisposedCondition("Admin Page"));
		ui.wait(new WindowShowingCondition("Warehouse Management"));
		ui.click(new JButtonLocator("Customer Options"));
		ui.wait(new WindowDisposedCondition("Warehouse Management"));
		ui.wait(new WindowShowingCondition("Customer page"));
		ui.click(new JButtonLocator("Go Back"));
		ui.wait(new WindowDisposedCondition("Customer page"));
	}

}