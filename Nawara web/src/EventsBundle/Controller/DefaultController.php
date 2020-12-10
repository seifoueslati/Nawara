<?php

namespace EventsBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('EventsBundle:Default:index.html.twig');
    }
    public function displayeventsAction()
    {
        return $this->render("@Events\displayevents.html.twig");
    }
}
