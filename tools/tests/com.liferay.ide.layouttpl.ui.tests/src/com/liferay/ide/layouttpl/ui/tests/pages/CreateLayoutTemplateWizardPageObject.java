
package com.liferay.ide.layouttpl.ui.tests.pages;

import com.liferay.ide.layouttpl.ui.tests.CreateLayouttplWizard;
import com.liferay.ide.ui.tests.swtbot.page.ButtonPageObject;
import com.liferay.ide.ui.tests.swtbot.page.ComboBoxPageObject;
import com.liferay.ide.ui.tests.swtbot.page.TextPageObject;
import com.liferay.ide.ui.tests.swtbot.page.WizardPageObject;

import org.eclipse.swtbot.swt.finder.SWTBot;

public class CreateLayoutTemplateWizardPageObject<T extends SWTBot> extends WizardPageObject<T>
    implements CreateLayouttplWizard
{

    ButtonPageObject<SWTBot> browseTemplateFile;
    ButtonPageObject<SWTBot> browseThumbnailFile;
    ButtonPageObject<SWTBot> browseWapTemplateFile;
    TextPageObject<SWTBot> id;
    ComboBoxPageObject<SWTBot> layoutPluginProject;
    TextPageObject<SWTBot> name;
    TextPageObject<SWTBot> templateFile;
    TextPageObject<SWTBot> thumbnailFile;
    TextPageObject<SWTBot> wapTemplateFile;

    public CreateLayoutTemplateWizardPageObject( T bot )
    {
        this( bot, TEXT_BLANK, BUTTON_CANCEL, BUTTON_FINISH, BUTTON_BACK, BUTTON_NEXT, INDEX_LAYOUTTPL_VALIDATION_MESSAGE1 );
    }

    
    public ButtonPageObject<SWTBot> getBrowseTemplateFile()
    {
        return browseTemplateFile;
    }

    
    public ButtonPageObject<SWTBot> getBrowseThumbnailFile()
    {
        return browseThumbnailFile;
    }

    
    public ButtonPageObject<SWTBot> getBrowseWapTemplateFile()
    {
        return browseWapTemplateFile;
    }

    public CreateLayoutTemplateWizardPageObject(
        T bot, String title, String cancelButtonText, String finishButtonText, String backButtonText,
        String nextButtonText, int validationMessageIndex )
    {
        super( bot, title, cancelButtonText, finishButtonText, backButtonText, nextButtonText, validationMessageIndex );
        layoutPluginProject = new ComboBoxPageObject<SWTBot>( bot, LABEL_LAYOUT_PLUGIN_PROJECT );
        name = new TextPageObject<SWTBot>( bot, LABEL_NAME );
        id = new TextPageObject<SWTBot>( bot, LABEL_ID );
        templateFile = new TextPageObject<SWTBot>( bot, LABEL_TEMPLATE_FILE );
        wapTemplateFile = new TextPageObject<SWTBot>( bot, LABEL_WAP_TEMPLATE_FILE );
        thumbnailFile = new TextPageObject<SWTBot>( bot, LABEL_THUMBNAIL_FILE );
        browseTemplateFile=new ButtonPageObject<SWTBot>( bot, BUTTON_BROWSE, 0 );
        browseWapTemplateFile=new ButtonPageObject<SWTBot>( bot, BUTTON_BROWSE, 1 );
        browseThumbnailFile=new ButtonPageObject<SWTBot>( bot, BUTTON_BROWSE, 2 );
    }

    public TextPageObject<SWTBot> getId()
    {
        return id;
    }

    public ComboBoxPageObject<SWTBot> getLayoutPluginProject()
    {
        return layoutPluginProject;
    }

    public TextPageObject<SWTBot> getName()
    {
        return name;
    }

    public TextPageObject<SWTBot> getTemplateFile()
    {
        return templateFile;
    }

    public TextPageObject<SWTBot> getThumbnailFile()
    {
        return thumbnailFile;
    }

    public TextPageObject<SWTBot> getWapTemplateFile()
    {
        return wapTemplateFile;
    }

}
