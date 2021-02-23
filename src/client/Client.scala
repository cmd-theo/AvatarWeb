package client

import machine._
import automaticTester.TestAvatar
import Implementations.MachineImpl

object Client extends App {
	TestAvatar.check(MachineImpl)
}
