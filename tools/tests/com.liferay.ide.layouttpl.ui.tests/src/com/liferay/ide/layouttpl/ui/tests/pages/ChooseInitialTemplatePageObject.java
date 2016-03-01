
package com.liferay.ide.layouttpl.ui.tests.pages;

import com.liferay.ide.layouttpl.ui.tests.CreateLayouttplWizard;
import com.liferay.ide.ui.tests.swtbot.page.RadioPageObject;
import com.liferay.ide.ui.tests.swtbot.page.WizardPageObject;

import org.eclipse.swtbot.swt.finder.SWTBot;

public class ChooseInitialTemplatePageObject<T extends SWTBot> extends WizardPageObject<T>
    implements CreateLayouttplWizard
{

    RadioPageObject<SWTBot> oneColumn;
    RadioPageObject<SWTBot> oneTwoColumns;
    RadioPageObject<SWTBot> oneTwoColumns2;
    RadioPageObject<SWTBot> oneTwoOneColumns;
    
    public RadioPageObject<SWTBot> getOneColumn()
    {
        return oneColumn;
    }

    
    public RadioPageObject<SWTBot> getOneTwoColumns()
    {
        return oneTwoColumns;
    }

    
    public RadioPageObject<SWTBot> getOneTwoColumns2()
    {
        return oneTwoColumns2;
    }

    
    public RadioPageObject<SWTBot> getOneTwoOneColumns()
    {
        return oneTwoOneColumns;
    }

    
    public RadioPageObject<SWTBot> getTwoColumns()
    {
        return twoColumns;
    }

    
    public RadioPageObject<SWTBot> getTwoColumns2()
    {
        return twoColumns2;
    }

    
    public RadioPageObject<SWTBot> getTwoColumns3()
    {
        return twoColumns3;
    }

    
    public RadioPageObject<SWTBot> getTwoTwoColumns()
    {
        return twoTwoColumns;
    }

    
    public RadioPageObject<SWTBot> getThreeColumns()
    {
        return threeColumns;
    }

    RadioPageObject<SWTBot> twoColumns;
    RadioPageObject<SWTBot> twoColumns2;
    RadioPageObject<SWTBot> twoColumns3;
    RadioPageObject<SWTBot> twoTwoColumns;
    RadioPageObject<SWTBot> threeColumns;

    public ChooseInitialTemplatePageObject( T bot )
    {
        this( bot, TEXT_BLANK, BUTTON_CANCEL, BUTTON_FINISH, BUTTON_BACK, BUTTON_NEXT, INDEX_LAYOUTTPL_VALIDATION_MESSAGE2 );
    }

    public ChooseInitialTemplatePageObject(
        T bot, String title, String cancelButtonText, String finishButtonText, String backButtonText,
        String nextButtonText, int validationMessageIndex )
    {
        super( bot, title, cancelButtonText, finishButtonText, backButtonText, nextButtonText, validationMessageIndex );
        oneColumn = new RadioPageObject<SWTBot>( bot, LABEL_1_COLUMN );
        oneTwoColumns = new RadioPageObject<SWTBot>( bot, LABEL_1_2_COLUMNS );
        oneTwoColumns2 = new RadioPageObject<SWTBot>( bot, LABEL_1_2_COLUMNS, 1 );
        oneTwoOneColumns = new RadioPageObject<SWTBot>( bot, LABEL_1_2_1_COLUMNS );
        twoColumns = new RadioPageObject<SWTBot>( bot, LABEL_2_COLUMNS );
        twoColumns2 = new RadioPageObject<SWTBot>( bot, LABEL_2_COLUMNS, 1 );
        twoColumns3 = new RadioPageObject<SWTBot>( bot, LABEL_2_COLUMNS, 2 );
        twoTwoColumns = new RadioPageObject<SWTBot>( bot, LABEL_2_2_COLUMNS );
        threeColumns = new RadioPageObject<SWTBot>( bot, LABEL_3_COLUMNS );
    }

}
