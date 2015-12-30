/*******************************************************************************
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 *
 *******************************************************************************/

package com.liferay.ide.project.ui.tests;

import com.liferay.ide.ui.tests.swtbot.page.CheckBoxPageObject;
import com.liferay.ide.ui.tests.swtbot.page.RadioPageObject;
import com.liferay.ide.ui.tests.swtbot.page.ComboBoxPageObject;
import com.liferay.ide.ui.tests.swtbot.page.TextPageObject;
import com.liferay.ide.ui.tests.swtbot.page.WizardPageObject;

import org.eclipse.swtbot.swt.finder.SWTBot;

/**
 * @author Ashley Yuan
 * @author Terry Jia
 */
public class CreateLiferayPortletWizardPageObject<T extends SWTBot> extends WizardPageObject<T>
    implements CreateLiferayPortletWizard, ProjectWizard
{

    public ComboBoxPageObject<SWTBot> portletPluginProject;
    public TextPageObject<SWTBot> sourceFolder;
    public RadioPageObject<SWTBot> createNewPortlet;
    public RadioPageObject<SWTBot> useDefaultPortlet;
    public TextPageObject<SWTBot> portletClass;
    public TextPageObject<SWTBot> javaPackage;
    public TextPageObject<SWTBot> superClass;

    public TextPageObject<SWTBot> name;
    public TextPageObject<SWTBot> displayName;
    public TextPageObject<SWTBot> title;

    public CheckBoxPageObject<SWTBot> view;
    public CheckBoxPageObject<SWTBot> edit;
    public CheckBoxPageObject<SWTBot> help;
    public CheckBoxPageObject<SWTBot> about;
    public CheckBoxPageObject<SWTBot> config;
    public CheckBoxPageObject<SWTBot> editDefaults;
    public CheckBoxPageObject<SWTBot> editGuest;
    public CheckBoxPageObject<SWTBot> preview;
    public CheckBoxPageObject<SWTBot> print;

    public CheckBoxPageObject<SWTBot> createJspFiles;
    public TextPageObject<SWTBot> jspFolder;

    public CheckBoxPageObject<SWTBot> createResourceBundleFile;
    public TextPageObject<SWTBot> reourceBundleFilePath;

    public TextPageObject<SWTBot> icon;
    public CheckBoxPageObject<SWTBot> allowMultipleInstances;
    public TextPageObject<SWTBot> css;
    public TextPageObject<SWTBot> javaScript;
    public TextPageObject<SWTBot> cssClassWrapper;

    public ComboBoxPageObject<SWTBot> displayCategory;

    public CheckBoxPageObject<SWTBot> addToControlPanel;
    public ComboBoxPageObject<SWTBot> entryCategory;
    public TextPageObject<SWTBot> entryWeight;

    public CheckBoxPageObject<SWTBot> createEntryClass;
    public TextPageObject<SWTBot> entryClass;

    public CheckBoxPageObject<SWTBot> publicModify;
    public CheckBoxPageObject<SWTBot> abstractModify;
    public CheckBoxPageObject<SWTBot> finalModify;

    public CheckBoxPageObject<SWTBot> constrFromSuperClass;
    public CheckBoxPageObject<SWTBot> inherAbstractMethods;

    public CheckBoxPageObject<SWTBot> init;
    public CheckBoxPageObject<SWTBot> destory;
    public CheckBoxPageObject<SWTBot> doView;
    public CheckBoxPageObject<SWTBot> doEdit;
    public CheckBoxPageObject<SWTBot> doHelp;
    public CheckBoxPageObject<SWTBot> doAbout;
    public CheckBoxPageObject<SWTBot> doConfig;
    public CheckBoxPageObject<SWTBot> doEditDefaults;
    public CheckBoxPageObject<SWTBot> doEditGuest;
    public CheckBoxPageObject<SWTBot> doPreview;
    public CheckBoxPageObject<SWTBot> doPrint;
    public CheckBoxPageObject<SWTBot> doProcessAction;
    public CheckBoxPageObject<SWTBot> doServeResource;

    public CreateLiferayPortletWizardPageObject( T bot )
    {
        this( bot, TEXT_BLANK );
    }

    public CreateLiferayPortletWizardPageObject( T bot, String title )
    {
        this( bot, title, INDEX_DEFAULT_VALIDATION_MESSAGE );
    }

    public CreateLiferayPortletWizardPageObject( T bot, String title, int validationMessageIndex )
    {
        super( bot, title, BUTTON_CANCEL, BUTTON_FINISH, BUTTON_BACK, BUTTON_NEXT, validationMessageIndex );

        portletPluginProject = new ComboBoxPageObject<SWTBot>( bot, LABEL_PORTLET_PLUGIN_PROJECT );
        sourceFolder = new TextPageObject<SWTBot>( bot, LABEL_SOURCE_FOLDER );
        createNewPortlet = new RadioPageObject<SWTBot>( bot, RADIO_CREATE_NEW_PORTLET );
        useDefaultPortlet = new RadioPageObject<SWTBot>( bot, RADIO_USE_DEFAULT_PORTLET );
        portletClass = new TextPageObject<SWTBot>( bot, LABEL_PORTLET_CLASS );
        javaPackage = new TextPageObject<SWTBot>( bot, LABEL_JAVA_PACKAGE );
        superClass = new TextPageObject<SWTBot>( bot, LABEL_SUPERCLASS );
    }

}
