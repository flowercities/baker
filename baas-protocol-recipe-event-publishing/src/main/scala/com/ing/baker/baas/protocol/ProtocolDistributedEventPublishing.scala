package com.ing.baker.baas.protocol

import com.ing.baker.runtime.scaladsl.{EventInstance, RecipeEventMetadata}
import com.ing.baker.runtime.serialization.BakerSerializable

sealed trait ProtocolDistributedEventPublishing extends BakerSerializable

object ProtocolDistributedEventPublishing {

  def eventsTopic(recipeName: String): String =
    s"recipe-event-publishing:$recipeName:event"

  case class Event(recipeEventMetadata: RecipeEventMetadata, event: EventInstance) extends ProtocolDistributedEventPublishing
}