package org.jayware.fact.client.application;


import org.jayware.skyshard.core.api.Application;
import org.jayware.skyshard.core.api.ApplicationService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(immediate = true)
public class FactClientApplication
{
    @Reference
    private ApplicationService myApplicationService;
//    private Application myApplication;

    @Activate
    void activate()
    {
//        myApplication = myApplicationService.createApplication();
    }
}
