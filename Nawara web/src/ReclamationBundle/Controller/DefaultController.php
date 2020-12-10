<?php

namespace ReclamationBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('ReclamationBundle:Default:index.html.twig');
    }
    public function displayreclamationAction()
    {
        return $this->render("@Reclamation\displayreclamation.html.twig");
    }


}
