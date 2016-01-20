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

package com.liferay.ide.ui.tests.swtbot.page;

import com.liferay.ide.ui.tests.swtbot.condition.WidgetEnabledCondition;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotCombo;

/**
 * @author Terry Jia
 * @author Li Lu
 */
public class ComboBoxPageObject<T extends SWTBot> extends AbstractWidgetPageObject<SWTBot>
{

    public ComboBoxPageObject( SWTBot bot, String label )
    {
        super( bot, label );
    }

    @Override
    protected SWTBotCombo getWidget()
    {
        return bot.comboBoxWithLabel( label );
    }

    public boolean hasItem( String itemName )
    {
        for( String item : items() )
        {
            if( itemName.equals( item ) )
            {
                return true;
            }
        }

        return false;
    }

    public String[] items()
    {
        return getWidget().items();
    }

    public void setSelection( String value )
    {
        SWTBotCombo combo = getWidget();

        bot.waitUntil( new WidgetEnabledCondition( combo, true ) );

        combo.setSelection( value );
    }

}
