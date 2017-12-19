package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

//FOR AN EXPLANATION PLEASE CHECK "TeleOp9328.java"

@TeleOp(name="9328: Single Driver", group="9328")
@Disabled
public class SingleDriverTeleOp9328 extends OpMode {
    HardwareMap9328 hwMap = new HardwareMap9328();
    double leftStick, rightStick;

    @Override
    public void init() {
        hwMap.claw.setTargetPosition(45);
    }

    @Override
    public void loop() {
        boolean clawState = false;

        leftStick   = gamepad1.left_stick_y;
        rightStick  = gamepad1.right_stick_y;

        hwMap.leftTread.setPower(leftStick);
        hwMap.rightTread.setPower(rightStick);

        if (gamepad1.dpad_up) {
            hwMap.clawWinch.setPower(0.75);
        } else if (gamepad1.dpad_down) {
            hwMap.clawWinch.setPower(-0.75);
        } else if (gamepad1.a & clawState == false) {
            hwMap.claw.setTargetPosition(0);
            clawState = true;
        } else if (gamepad1.a & clawState == true) {
            hwMap.claw.setTargetPosition(45);
            clawState = false;
        } else {
            hwMap.clawWinch.setPower(0);
        }
    }
}
