
package com.liferay.ide.layouttpl.ui.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.liferay.ide.layouttpl.ui.tests.pages.ChooseInitialTemplatePageObject;
import com.liferay.ide.layouttpl.ui.tests.pages.CreateLayoutTemplateWizardPageObject;
import com.liferay.ide.layouttpl.ui.tests.pages.TempalteSelectionDialogObject;
import com.liferay.ide.project.ui.tests.page.CreateProjectWizardPageObject;
import com.liferay.ide.project.ui.tests.page.SetSDKLocationPageObject;
import com.liferay.ide.ui.tests.ProjectWizard;
import com.liferay.ide.ui.tests.SWTBotBase;
import com.liferay.ide.ui.tests.WizardBase;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NewLayoutTemplateWizardTests extends SWTBotBase
    implements CreateLayouttplWizard, ProjectWizard, WizardBase
{

    static String projectName = "test";

    @BeforeClass
    public static void createProject()
    {
        openWizard( MENU_NEW_LIFERAY_PLUGIN_PROJECT );

        CreateProjectWizardPageObject<SWTWorkbenchBot> page1 = new CreateProjectWizardPageObject<SWTWorkbenchBot>( bot );
        page1.createSDKProject( projectName, MENU_LAYOUT_TEMPLATE );

        if( page1.finishButton().isEnabled() )
        {
            page1.finish();
        }
        else
        {
            page1.next();
            SetSDKLocationPageObject<SWTWorkbenchBot> page2 = new SetSDKLocationPageObject<>( bot, "" );
            page2.setSdkLocation( getLiferayPluginsSdkDir().toString() );
            page2.finish();
        }
    }

    CreateLayoutTemplateWizardPageObject<SWTWorkbenchBot> page =
        new CreateLayoutTemplateWizardPageObject<SWTWorkbenchBot>( bot );

    ChooseInitialTemplatePageObject<SWTWorkbenchBot> page2 = new ChooseInitialTemplatePageObject<SWTWorkbenchBot>( bot );

    @After
    public void closeWizard()
    {
        try
        {
            bot.shell( "New Layout Template" ).close();
        }
        catch( Exception e )
        {
        }
    }

    @Before
    public void openWizard()
    {
        openWizard( MENU_NEW_LIFERAY_LAYOUT_TEMP );
    }

    @Test
    public void testContentDefaultValues() throws Exception
    {
        // check default values page 1
        assertEquals( projectName + "-layouttpl", page.getLayoutPluginProject().getText() );
        assertEquals( "New Template", page.getName().getText() );
        assertEquals( "newtemplate", page.getId().getText() );
        assertEquals( "/newtemplate.tpl", page.getTemplateFile().getText() );
        assertEquals( "/newtemplate.wap.tpl", page.getWapTemplateFile().getText() );
        assertEquals( "/newtemplate.png", page.getThumbnailFile().getText() );

        assertEquals( true, page.getLayoutPluginProject().isEnabled() );
        assertEquals( true, page.getName().isEnabled() );
        assertEquals( true, page.getId().isEnabled() );
        assertEquals( true, page.getTemplateFile().isEnabled() );
        assertEquals( true, page.getWapTemplateFile().isEnabled() );
        assertEquals( true, page.getThumbnailFile().isEnabled() );

        // page2
        page.next();

        assertEquals( true, page2.getOneColumn().isSelected() );
        assertEquals( false, page2.getOneTwoColumns().isSelected() );
        assertEquals( false, page2.getOneTwoColumns().isSelected() );
        assertEquals( false, page2.getOneTwoColumns2().isSelected() );
        assertEquals( false, page2.getOneTwoOneColumns().isSelected() );
        assertEquals( false, page2.getTwoColumns().isSelected() );
        assertEquals( false, page2.getTwoColumns2().isSelected() );
        assertEquals( false, page2.getTwoColumns3().isSelected() );
        assertEquals( false, page2.getTwoTwoColumns().isSelected() );
        assertEquals( false, page2.getThreeColumns().isSelected() );

        assertEquals( true, page2.getOneColumn().isEnabled() );
        assertEquals( true, page2.getOneTwoColumns().isEnabled() );
        assertEquals( true, page2.getOneTwoColumns().isEnabled() );
        assertEquals( true, page2.getOneTwoColumns2().isEnabled() );
        assertEquals( true, page2.getOneTwoOneColumns().isEnabled() );
        assertEquals( true, page2.getTwoColumns().isEnabled() );
        assertEquals( true, page2.getTwoColumns2().isEnabled() );
        assertEquals( true, page2.getTwoColumns3().isEnabled() );
        assertEquals( true, page2.getTwoTwoColumns().isEnabled() );
        assertEquals( true, page2.getThreeColumns().isEnabled() );
    }

    @Test
    public void testCreateLayoutTemplate()
    {
        page.getName().setText( "Test Template" );
        page.getId().setText( "testtesttemplate" );
        page.getTemplateFile().setText( "testtemplate.tpl" );
        page.getWapTemplateFile().setText( "testtemplate.wap.tpl" );
        page.getThumbnailFile().setText( "testtemplate.png" );

        page.next();
        ChooseInitialTemplatePageObject<SWTWorkbenchBot> page2 =
            new ChooseInitialTemplatePageObject<SWTWorkbenchBot>( bot );
        page2.getOneTwoColumns().click();
        page.finish();

    }

    @Test
    public void testID()
    {
        page.getId().setText( "" );

        assertEquals( "New Template", page.getName().getText() );
        assertEquals( "/.tpl", page.getTemplateFile().getText() );
        assertEquals( "/.wap.tpl", page.getWapTemplateFile().getText() );
        assertEquals( "/.png", page.getThumbnailFile().getText() );
        assertEquals( TEXT_ID_CANNT_BE_EMPTY, page.getValidationMessage() );
        assertEquals( false, page.finishButton().isEnabled() );

        page.getId().setText( "layout test" );
        assertEquals( "New Template", page.getName().getText() );
        assertEquals( "/layout test.tpl", page.getTemplateFile().getText() );
        assertEquals( "/layout test.wap.tpl", page.getWapTemplateFile().getText() );
        assertEquals( "/layout test.png", page.getThumbnailFile().getText() );
        assertEquals( TEXT_ID_INVALID, page.getValidationMessage() );
        assertEquals( false, page.finishButton().isEnabled() );

        page.getId().setText( "newtemplate" );
        assertEquals( TEXT_DEFAULT_MESSAGE, page.getValidationMessage() );
    }

    @Test
    public void testName()
    {
        page.getName().setText( "" );

        assertEquals( "", page.getId().getText() );
        assertEquals( "/.tpl", page.getTemplateFile().getText() );
        assertEquals( "/.wap.tpl", page.getWapTemplateFile().getText() );
        assertEquals( "/.png", page.getThumbnailFile().getText() );
        assertEquals( TEXT_ID_CANNT_BE_EMPTY, page.getValidationMessage() );
        assertEquals( false, page.finishButton().isEnabled() );

        page.getName().setText( "New_ Template" );
        assertEquals( "newtemplate", page.getId().getText() );
        assertEquals( TEXT_DEFAULT_MESSAGE, page.getValidationMessage() );

        page.getName().setText( "" );
        page.getId().setText( "newtemplate" );
        assertEquals( TEXT_DEFAULT_MESSAGE, page.getValidationMessage() );
    }

    @Test
    public void testTemplateFile()
    {
        page.getBrowseTemplateFile().click();

        TempalteSelectionDialogObject<SWTWorkbenchBot> templateFileSelection =
            new TempalteSelectionDialogObject<SWTWorkbenchBot>( bot );

        assertTrue( templateFileSelection.containsItem( "test.tpl" ) );
        assertTrue( templateFileSelection.containsItem( "test.png" ) );
        assertTrue( templateFileSelection.containsItem( "test.wap.tpl" ) );

        templateFileSelection.select( "WEB-INF" );
        assertEquals( TEXT_CHOOSE_VALID_PROJECT_FILE, templateFileSelection.getValidationMessage() );
        assertEquals( false, templateFileSelection.canFinish() );

        templateFileSelection.select( "test.tpl" );
        templateFileSelection.confirm();

        assertEquals( TEXT_TEMPLATE_FILE_EXIST, page.getValidationMessage() );
        assertEquals( true, page.finishButton().isEnabled() );

        page.getTemplateFile().setText( "" );
        assertEquals( TEXT_TEMPLATE_FILE_INVALID, page.getValidationMessage() );
        assertEquals( false, page.finishButton().isEnabled() );

        page.getTemplateFile().setText( "aa.tpl" );
        assertEquals( true, page.finishButton().isEnabled() );
    }

    @Test
    public void testThumbnailFile()
    {
        page.getBrowseThumbnailFile().click();

        TempalteSelectionDialogObject<SWTWorkbenchBot> thumbnailFileSelection =
            new TempalteSelectionDialogObject<SWTWorkbenchBot>( bot );

        assertTrue( thumbnailFileSelection.containsItem( "test.tpl" ) );
        assertTrue( thumbnailFileSelection.containsItem( "test.png" ) );
        assertTrue( thumbnailFileSelection.containsItem( "test.wap.tpl" ) );

        thumbnailFileSelection.select( "WEB-INF" );

        assertEquals( TEXT_CHOOSE_VALID_PROJECT_FILE, thumbnailFileSelection.getValidationMessage() );
        assertEquals( false, thumbnailFileSelection.canFinish() );

        thumbnailFileSelection.select( "test.wap.tpl" );
        thumbnailFileSelection.confirm();

        assertEquals( TEXT_THUMBNAIL_FILE_EXIST, page.getValidationMessage() );
        assertEquals( true, page.finishButton().isEnabled() );

        page.getThumbnailFile().setText( "" );
        assertEquals( TEXT_THUMBNAIL_FILE_INVALID, page.getValidationMessage() );
        assertEquals( false, page.finishButton().isEnabled() );

        page.getThumbnailFile().setText( "/aa.wap.tpl" );
        assertEquals( true, page.finishButton().isEnabled() );
    }

    @Test
    public void testWapTemplateFile()
    {
        page.getBrowseWapTemplateFile().click();

        TempalteSelectionDialogObject<SWTWorkbenchBot> templateFileSelection =
            new TempalteSelectionDialogObject<SWTWorkbenchBot>( bot );

        assertTrue( templateFileSelection.containsItem( "test.tpl" ) );
        assertTrue( templateFileSelection.containsItem( "test.png" ) );
        assertTrue( templateFileSelection.containsItem( "test.wap.tpl" ) );

        templateFileSelection.select( "WEB-INF" );
        assertEquals( TEXT_CHOOSE_VALID_PROJECT_FILE, templateFileSelection.getValidationMessage() );
        assertEquals( false, templateFileSelection.canFinish() );

        templateFileSelection.select( "test.wap.tpl" );
        templateFileSelection.confirm();

        assertEquals( TEXT_WAP_TEMPLATE_FILE_EXIST, page.getValidationMessage() );
        assertEquals( true, page.finishButton().isEnabled() );

        page.getWapTemplateFile().setText( "" );
        assertEquals( TEXT_WAP_TEMPLATE_FILE_INVALID, page.getValidationMessage() );
        assertEquals( false, page.finishButton().isEnabled() );

        page.getWapTemplateFile().setText( "/aa.wap.tpl" );
        assertEquals( true, page.finishButton().isEnabled() );
    }
}
