<?php

namespace PanierBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('PanierBundle:Default:index.html.twig');
    }
    public function displaypanierAction()
    {
        return $this->render('@Panier\displaypanier.html.twig');
    }
}
