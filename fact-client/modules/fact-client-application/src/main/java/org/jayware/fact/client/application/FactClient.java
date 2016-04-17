/**
 * Skyshard Engine -- A 3D game engine written in Java
 *
 * Copyright (C) 2016 Markus Neubauer <markus.neubauer@jayware.org>,
 *                    Alexander Haumann <alexander.haumann@jayware.org>,
 *                    Manuel Hinke <manuel.hinke@jayware.org>,
 *                    Marina Schilling <marina.schilling@jayware.org>,
 *                    Elmar Schug <elmar.schug@jayware.org>,
 *
 *     This file is part of the Skyshard Engine.
 *
 *     The Skyshard Engine is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU Lesser General Public License
 *     as published by the Free Software Foundation, either version 3 of
 *     the License, or any later version.
 *
 *     The Skyshard Engine is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 *     Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jayware.fact.client.application;


import org.jayware.skyshard.application.api.Application;
import org.jayware.skyshard.graphics.api.Window;
import org.jayware.skyshard.graphics.api.WindowManager;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component(immediate = true)
public class FactClient
{
    private static final Logger log = LoggerFactory.getLogger(FactClient.class);

    private Application myApplication;
    private WindowManager myWindowManager;
    private Window myWindow;

    @Activate
    void activate()
    {
        log.info("=================================================================");
        log.info("= Started F.A.C.T. Client: " + myApplication.getId() + " =");
        log.info("=================================================================");

        myWindow = myWindowManager.createWindow();
        myWindow.setSize(1024, 768);

    }

    void deactivate()
    {
        myWindow.destroy();
    }

    @Reference
    void bindApplication(Application application)
    {
        myApplication = application;
    }

    void unbindApplication(Application application)
    {
        myApplication = null;
    }

    @Reference
    void bindWindowManager(WindowManager windowManager)
    {
        myWindowManager = windowManager;
    }

    void unbindWindowManager(WindowManager windowManager)
    {
        myWindowManager = null;
    }
}
