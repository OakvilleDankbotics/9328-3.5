package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="9328: TeleOp Linear", group="9328")
public class TeleOpLinear extends LinearOpMode {
    HardwareMap9328 hwMap = new HardwareMap9328();
    double leftStick1, rightStick1, leftStick2, rightStick2;
    boolean clawState = false;

    @Override
    public void runOpMode() {
        hwMap.init(hardwareMap);
        waitForStart();

        hwMap.claw.setTargetPosition(45);
        while (opModeIsActive()) {
            leftStick1   = gamepad1.left_stick_y;
            rightStick1  = gamepad1.right_stick_y;
            leftStick2   = gamepad2.left_stick_y;
            rightStick2  = gamepad2.right_stick_y;

            hwMap.leftTread.setPower(leftStick1);
            hwMap.rightTread.setPower(rightStick1);

            if (rightStick2 > 0.2 || rightStick2 < -0.2) {
                hwMap.clawWinch.setPower(rightStick2);
            } else if (gamepad2.right_stick_button & !clawState) {
                hwMap.claw.setTargetPosition(0);
                clawState = true;
            } else if (gamepad2.right_stick_button & clawState) {
                hwMap.claw.setTargetPosition(45);
                clawState = false;
            } else {
                hwMap.clawWinch.setPower(0);
            }
        }
    }
}
