<?php

namespace AcceuilBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('AcceuilBundle:Default:index.html.twig');
    }
    public function accueilAction()
    {
        return $this->render("@Acceuil\acceuil.html.twig");
    }
    public function connecterAction()
    {
        return $this->render("@Acceuil\connecter.html.twig");
    }
    public function backofficeAction()
    {
        return $this->render("@Acceuil\backoffice.html.twig");
    }
    public function administrateursAction()
    {
        return $this->render("@Acceuil\administrateurs.html.twig");
    }
}
