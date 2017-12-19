package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="9328: TeleOp", group="9328")
@Disabled
public class TeleOp9328 extends OpMode {
    HardwareMap9328 hwMap = new HardwareMap9328();
    double leftStick1, rightStick1, leftStick2, rightStick2;

    @Override
    public void init() {
        //Runs once after pressing init
        hwMap.claw.setTargetPosition(45);

        /**
         * This is here to do 2 things
         * first make sure the bot doesn't dab when initialized like it did last time
         * second is to make sure that the clawState boolean is correct
         **/
    }

    @Override
    public void loop() {
        //Runs repeatedly after pressing start
        boolean clawState = false;

        /**
         * False = Open; True = Closed
         * This is here so that when the driver pressed down on the right stick
         * It can change what it does depending upon this variable
         * in this case the bot will open the claw if this is set to true (Claw is closed)
         * BUT if this is set to false (Claw is opened) it will close the claw
         * If I decide to make a Single Driver TeleOp it will probably be the terrible button
         * combo that it was during our first competition (Sorry UwU)
         **/

        leftStick1   = gamepad1.left_stick_y;
        rightStick1  = gamepad1.right_stick_y;
        leftStick2   = gamepad2.left_stick_y;
        rightStick2  = gamepad2.right_stick_y;

        hwMap.leftTread.setPower(leftStick1);
        hwMap.rightTread.setPower(rightStick1);

        if (rightStick2 > 0.2 || rightStick2 < -0.2) {
            hwMap.clawWinch.setPower(rightStick2);
        } else if (gamepad2.right_stick_button & clawState == false) {
            hwMap.claw.setTargetPosition(0);
            clawState = true;
        } else if (gamepad2.right_stick_button & clawState == true) {
            //hwMap.claw.setTargetPosition(45);
            clawState = false;
        } else {
            hwMap.clawWinch.setPower(0);
        }
    }
}
