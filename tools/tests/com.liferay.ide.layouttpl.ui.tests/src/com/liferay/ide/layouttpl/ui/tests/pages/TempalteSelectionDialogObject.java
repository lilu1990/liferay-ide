
package com.liferay.ide.layouttpl.ui.tests.pages;

import com.liferay.ide.ui.tests.swtbot.page.AbstractSelectionPageObject;

import org.eclipse.swtbot.swt.finder.SWTBot;

public class TempalteSelectionDialogObject<T extends SWTBot> extends AbstractSelectionPageObject<SWTBot>
{

    public TempalteSelectionDialogObject( SWTBot bot )
    {
        this( bot, TEXT_BLANK );
    }

    public TempalteSelectionDialogObject( SWTBot bot, String title )
    {
        super( bot, title );
    }

    public String getValidationMessage()
    {
        return bot.clabel().getText();
    }

    public boolean containsItem( String... items )
    {
        return getSelcetFileTree().hasTreeItem( items );
    }

    public void select( String... items )
    {
        getSelcetFileTree().selectTreeItem( items );
    }

    public boolean canFinish()
    {
        return confirmButton().isEnabled();
    }

}
