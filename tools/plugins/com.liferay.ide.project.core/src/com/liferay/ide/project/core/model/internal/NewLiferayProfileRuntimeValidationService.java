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
package com.liferay.ide.project.core.model.internal;

import com.liferay.ide.project.core.model.NewLiferayPluginProjectOp;
import com.liferay.ide.project.core.model.NewLiferayProfile;
import com.liferay.ide.server.util.ServerUtil;

import org.eclipse.sapphire.modeling.Status;
import org.eclipse.sapphire.services.ValidationService;
import org.eclipse.wst.server.core.IRuntime;


/**
 * @author Tao Tao
 */
public class NewLiferayProfileRuntimeValidationService extends ValidationService
{

    @Override
    protected Status compute()
    {
        Status retval = Status.createOkStatus();

        final NewLiferayPluginProjectOp op = context( NewLiferayPluginProjectOp.class );

        if( "maven".equals( op.getProjectProvider().content( true ).getShortName() ) ) //$NON-NLS-1$
        {
            final NewLiferayProfile newLiferayProfile = context( NewLiferayProfile.class );

            final String runtimeName = newLiferayProfile.getRuntimeName().content( true );

            IRuntime runtime = ServerUtil.getRuntime( runtimeName );

            if( runtime == null )
            {
                retval = Status.createErrorStatus( "Liferay runtime must be configured." );
            }
        }

        return retval;
    }
}
