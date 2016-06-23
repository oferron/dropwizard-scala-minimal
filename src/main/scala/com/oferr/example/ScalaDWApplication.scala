package com.oferr.example

import javax.ws.rs.{QueryParam, GET, Produces, Path}

import com.datasift.dropwizard.scala.ScalaApplication
import io.dropwizard.Configuration
import io.dropwizard.setup.Environment

/**
  * Created with IntelliJ IDEA.
  * User: oferr
  * Date: 6/23/16
  * Time: 13:47
  */
object ScalaDWApplication extends ScalaApplication[Configuration] {

  def run(t: Configuration, environment: Environment): Unit = {
    environment.jersey().register(new TestQuery())
  }


  @Path("/test")
  @Produces(Array("application/json"))
  class TestQuery() {

    @GET
    def sayHello(@QueryParam("name") name: Option[String]): String = s"Hello, ${name.getOrElse("no one")}"

  }

}

