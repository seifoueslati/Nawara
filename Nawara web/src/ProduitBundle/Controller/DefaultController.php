<?php

namespace ProduitBundle\Controller;

use Symfony\Bundle\FrameworkBundle\Controller\Controller;

class DefaultController extends Controller
{
    public function indexAction()
    {
        return $this->render('ProduitBundle:Default:index.html.twig');
    }
    public function displayproduitAction()
    {
        return $this->render('@Produit\displayproduit.html.twig');
    }
}
