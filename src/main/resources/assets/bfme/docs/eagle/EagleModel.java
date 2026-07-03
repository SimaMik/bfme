package net.sima.bfme.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.sima.bfme.entity.animations.ModAnimationDefinitions;
import net.sima.bfme.entity.custom.Eagle;


public class EagleModel<T extends Eagle> extends HierarchicalModel<T> {

        private final ModelPart eagle;
        private final ModelPart body;
        private final ModelPart head;
        private final ModelPart wing_left;
        private final ModelPart wing_right;

        public EagleModel(ModelPart root) {
            this.eagle = root.getChild("eagle");
            this.body = eagle.getChild("body");
            this.head = eagle.getChild("head");
            this.wing_left = eagle.getChild("wing_left");
            this.wing_right = eagle.getChild("wing_right");
        }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition eagle = partdefinition.addOrReplaceChild("eagle", CubeListBuilder.create(), PartPose.offset(-1.0F, 3.0F, 6.0F));

        PartDefinition head = eagle.addOrReplaceChild("head", CubeListBuilder.create().texOffs(113, 27).addBox(-4.0F, -29.0F, -40.0F, 8.0F, 10.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition upper_jaw = head.addOrReplaceChild("upper_jaw", CubeListBuilder.create().texOffs(169, 166).addBox(-6.0F, -35.0F, -40.0F, 6.0F, 4.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(30, 183).addBox(-5.0F, -36.0F, -39.0F, 4.0F, 1.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(189, 189).addBox(-1.0F, -31.0F, -40.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(149, 189).addBox(-6.0F, -31.0F, -40.0F, 1.0F, 1.0F, 11.0F, new CubeDeformation(0.0F))
                .texOffs(97, 95).addBox(-6.0F, -34.0F, -42.0F, 6.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 7).addBox(-1.0F, -30.0F, -40.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-6.0F, -30.0F, -40.0F, 1.0F, 3.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 7.0F, -11.0F));

        PartDefinition bottom_jaw = head.addOrReplaceChild("bottom_jaw", CubeListBuilder.create().texOffs(74, 114).addBox(-5.0F, -30.0F, -40.0F, 4.0F, 3.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, 7.0F, -11.0F));

        PartDefinition neck = eagle.addOrReplaceChild("neck", CubeListBuilder.create().texOffs(71, 77).addBox(-2.0F, -22.0F, -37.0F, 4.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 12.0F, 8.0F));

        PartDefinition cube_r1 = neck.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(59, 153).addBox(-3.0F, -16.0F, -11.0F, 6.0F, 14.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -23.0F, -26.0F, 0.5236F, 0.0F, 0.0F));

        PartDefinition body = eagle.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-8.0F, -31.0F, -35.0F, 16.0F, 18.0F, 32.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 13.0F, 10.0F));

        PartDefinition wing_left = eagle.addOrReplaceChild("wing_left", CubeListBuilder.create(), PartPose.offset(1.0F, 26.0F, 4.0F));

        PartDefinition part1 = wing_left.addOrReplaceChild("part1", CubeListBuilder.create().texOffs(64, 0).addBox(0.0F, -25.4F, -42.0F, 36.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(7.0F, -15.6F, 16.0F));

        PartDefinition feathers = part1.addOrReplaceChild("feathers", CubeListBuilder.create().texOffs(56, 77).addBox(1.0F, -26.0F, -46.0F, 1.0F, 0.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(81, 29).addBox(34.0F, -26.0F, -46.0F, 2.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(60, 0).addBox(36.0F, -26.0F, -51.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(8, 18).addBox(30.0F, -26.0F, -46.0F, 1.0F, 0.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(81, 51).addBox(31.0F, -26.0F, -46.0F, 2.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(62, 0).addBox(33.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(10, 18).addBox(26.0F, -26.0F, -46.0F, 1.0F, 0.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(83, 73).addBox(27.0F, -26.0F, -46.0F, 2.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(54, 77).addBox(29.0F, -26.0F, -46.0F, 1.0F, 0.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(89, 29).addBox(-1.0F, -26.0F, -46.0F, 2.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(14, 18).addBox(-2.0F, -26.0F, -46.0F, 1.0F, 0.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(12, 18).addBox(2.0F, -26.0F, -46.0F, 1.0F, 0.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(87, 73).addBox(3.0F, -26.0F, -46.0F, 2.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(63, 91).addBox(15.0F, -26.0F, -46.0F, 1.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(20, 77).addBox(14.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(10, 77).addBox(12.0F, -26.0F, -46.0F, 2.0F, 0.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(0, 77).addBox(21.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(76, 73).addBox(24.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 77).addBox(22.0F, -26.0F, -46.0F, 2.0F, 0.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(59, 91).addBox(25.0F, -26.0F, -46.0F, 1.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(18, 77).addBox(16.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(16, 77).addBox(19.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(6, 77).addBox(17.0F, -26.0F, -46.0F, 2.0F, 0.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(61, 91).addBox(20.0F, -26.0F, -46.0F, 1.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(22, 77).addBox(11.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(85, 29).addBox(9.0F, -26.0F, -46.0F, 2.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(24, 77).addBox(8.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(85, 51).addBox(6.0F, -26.0F, -46.0F, 2.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(26, 77).addBox(5.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(1.0F, 1.6F, 18.0F));

        PartDefinition part2 = wing_left.addOrReplaceChild("part2", CubeListBuilder.create().texOffs(0, 68).addBox(-1.0F, -24.0F, -40.0F, 37.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(44.0F, -16.6F, 16.0F));

        PartDefinition feathers2 = part2.addOrReplaceChild("feathers2", CubeListBuilder.create().texOffs(159, 51).addBox(-41.0F, -28.0F, -18.0F, 2.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(129, 150).addBox(-35.0F, -28.0F, -18.0F, 2.0F, 1.0F, 17.0F, new CubeDeformation(0.0F))
                .texOffs(135, 112).addBox(-30.0F, -28.0F, -18.0F, 2.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(179, 27).addBox(-39.0F, -28.0F, -18.0F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(87, 177).addBox(-32.0F, -28.0F, -18.0F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(36, 166).addBox(-31.0F, -28.0F, -18.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(18, 165).addBox(-28.0F, -28.0F, -18.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 145).addBox(-27.0F, -28.0F, -18.0F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(0, 7).addBox(-23.0F, -28.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(0, 86).addBox(-22.0F, -28.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(4, 85).addBox(-19.0F, -28.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(84, 77).addBox(-15.0F, -28.0F, 2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 83).addBox(-8.0F, -28.0F, 2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 20).addBox(-16.0F, -28.0F, -1.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 60).addBox(-9.0F, -28.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(6, 59).addBox(-4.0F, -28.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 68).addBox(-5.0F, -28.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 72).addBox(-3.0F, -28.0F, 1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 20).addBox(-2.0F, -28.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 22).addBox(-22.0F, -28.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(120, 71).addBox(-26.0F, -28.0F, -18.0F, 1.0F, 1.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(92, 51).addBox(-25.0F, -28.0F, -18.0F, 2.0F, 1.0F, 21.0F, new CubeDeformation(0.0F))
                .texOffs(172, 181).addBox(-23.0F, -28.0F, -18.0F, 1.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(55, 177).addBox(-22.0F, -28.0F, -18.0F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(66, 134).addBox(-21.0F, -28.0F, -18.0F, 2.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(143, 92).addBox(-19.0F, -28.0F, -18.0F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(0, 164).addBox(-16.0F, -28.0F, -18.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(108, 141).addBox(-8.0F, -28.0F, -18.0F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(157, 111).addBox(-9.0F, -28.0F, -18.0F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F))
                .texOffs(142, 70).addBox(-15.0F, -28.0F, -18.0F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(122, 92).addBox(-14.0F, -28.0F, -18.0F, 1.0F, 1.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(0, 100).addBox(-13.0F, -28.0F, -18.0F, 2.0F, 1.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(49, 113).addBox(-7.0F, -28.0F, -18.0F, 3.0F, 1.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(121, 116).addBox(-4.0F, -28.0F, -2.0F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(181, 95).addBox(-4.0F, -28.0F, -5.0F, 16.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(128, 143).addBox(-4.0F, -28.0F, -1.0F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 28).addBox(0.0F, -28.0F, 0.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 77).addBox(2.0F, -28.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 11).addBox(6.0F, -28.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 81).addBox(4.0F, -28.0F, 2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 124).addBox(-4.0F, -28.0F, -7.0F, 18.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(187, 187).addBox(-4.0F, -28.0F, -8.0F, 16.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(181, 103).addBox(-4.0F, -28.0F, -11.0F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(179, 43).addBox(-4.0F, -28.0F, -12.0F, 20.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(178, 149).addBox(-4.0F, -28.0F, -13.0F, 21.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(121, 184).addBox(-4.0F, -28.0F, -14.0F, 17.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(187, 185).addBox(-4.0F, -28.0F, -16.0F, 16.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(181, 101).addBox(-4.0F, -28.0F, -17.0F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(178, 159).addBox(-4.0F, -28.0F, -18.0F, 20.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(175, 145).addBox(-4.0F, -28.0F, -19.0F, 22.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(146, 18).addBox(-4.0F, -28.0F, -21.0F, 23.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(181, 99).addBox(-4.0F, -28.0F, -22.0F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(178, 157).addBox(-4.0F, -28.0F, -23.0F, 20.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(177, 49).addBox(-4.0F, -28.0F, -24.0F, 21.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(154, 25).addBox(-4.0F, -28.0F, -25.0F, 23.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(146, 21).addBox(-4.0F, -28.0F, -26.0F, 24.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(142, 27).addBox(-4.0F, -28.0F, -27.0F, 25.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(190, 161).addBox(5.0F, -28.0F, -28.0F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(190, 163).addBox(-4.0F, -28.0F, -15.0F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(192, 89).addBox(-4.0F, -28.0F, -9.0F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(157, 184).addBox(-4.0F, -28.0F, -10.0F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(49, 91).addBox(-11.0F, -28.0F, -18.0F, 2.0F, 1.0F, 21.0F, new CubeDeformation(0.0F))
                .texOffs(97, 73).addBox(-18.0F, -28.0F, -18.0F, 1.0F, 1.0F, 21.0F, new CubeDeformation(0.0F))
                .texOffs(0, 77).addBox(-17.0F, -28.0F, -18.0F, 1.0F, 1.0F, 22.0F, new CubeDeformation(0.0F))
                .texOffs(15, 182).addBox(-33.0F, -28.0F, -18.0F, 1.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(104, 178).addBox(-37.0F, -28.0F, -18.0F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(151, 166).addBox(-36.0F, -28.0F, -18.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(179, 51).addBox(-38.0F, -28.0F, -18.0F, 1.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(40.0F, 4.0F, -14.0F));

        PartDefinition wing_right = eagle.addOrReplaceChild("wing_right", CubeListBuilder.create(), PartPose.offset(-6.0F, 10.0F, 20.0F));

        PartDefinition part3 = wing_right.addOrReplaceChild("part3", CubeListBuilder.create().texOffs(0, 50).addBox(-36.0F, -25.4F, -42.0F, 36.0F, 2.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.4F, 0.0F));

        PartDefinition feathers3 = part3.addOrReplaceChild("feathers3", CubeListBuilder.create().texOffs(0, 77).addBox(-2.0F, -26.0F, -46.0F, 1.0F, 0.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(79, 73).addBox(-36.0F, -26.0F, -46.0F, 2.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(58, 0).addBox(-37.0F, -26.0F, -51.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(6, 18).addBox(-31.0F, -26.0F, -46.0F, 1.0F, 0.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(77, 51).addBox(-33.0F, -26.0F, -46.0F, 2.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(56, 0).addBox(-34.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(4, 18).addBox(-27.0F, -26.0F, -46.0F, 1.0F, 0.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(46, 77).addBox(-29.0F, -26.0F, -46.0F, 2.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(0, 50).addBox(-30.0F, -26.0F, -46.0F, 1.0F, 0.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(42, 77).addBox(-1.0F, -26.0F, -46.0F, 2.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(1.0F, -26.0F, -46.0F, 1.0F, 0.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-3.0F, -26.0F, -46.0F, 1.0F, 0.0F, 14.0F, new CubeDeformation(0.0F))
                .texOffs(38, 77).addBox(-5.0F, -26.0F, -46.0F, 2.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(91, 51).addBox(-16.0F, -26.0F, -46.0F, 1.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(54, 0).addBox(-15.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(8, 0).addBox(-14.0F, -26.0F, -46.0F, 2.0F, 0.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(52, 0).addBox(-22.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(50, 0).addBox(-25.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(4, 0).addBox(-24.0F, -26.0F, -46.0F, 2.0F, 0.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(89, 51).addBox(-26.0F, -26.0F, -46.0F, 1.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(48, 0).addBox(-17.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(14, 16).addBox(-20.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-19.0F, -26.0F, -46.0F, 2.0F, 0.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(50, 77).addBox(-21.0F, -26.0F, -46.0F, 1.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(-12.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(34, 77).addBox(-11.0F, -26.0F, -46.0F, 2.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(14, 0).addBox(-9.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(73, 51).addBox(-8.0F, -26.0F, -46.0F, 2.0F, 0.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-6.0F, -26.0F, -46.0F, 1.0F, 0.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.0F, 1.6F, 18.0F));

        PartDefinition part4 = wing_right.addOrReplaceChild("part4", CubeListBuilder.create().texOffs(64, 18).addBox(-36.0F, -24.0F, -40.0F, 37.0F, 1.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-37.0F, -0.6F, 0.0F));

        PartDefinition feathers4 = part4.addOrReplaceChild("feathers4", CubeListBuilder.create().texOffs(159, 32).addBox(39.0F, -28.0F, -18.0F, 2.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(21, 147).addBox(33.0F, -28.0F, -18.0F, 2.0F, 1.0F, 17.0F, new CubeDeformation(0.0F))
                .texOffs(44, 133).addBox(28.0F, -28.0F, -18.0F, 2.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(177, 1).addBox(38.0F, -28.0F, -18.0F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(176, 108).addBox(31.0F, -28.0F, -18.0F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(163, 91).addBox(30.0F, -28.0F, -18.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(162, 68).addBox(27.0F, -28.0F, -18.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(88, 140).addBox(26.0F, -28.0F, -18.0F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(22.0F, -28.0F, -3.0F, 1.0F, 1.0F, 6.0F, new CubeDeformation(0.0F))
                .texOffs(82, 71).addBox(21.0F, -28.0F, 1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(82, 68).addBox(18.0F, -28.0F, 0.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(6, 82).addBox(14.0F, -28.0F, 2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(7, 79).addBox(7.0F, -28.0F, 2.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(15.0F, -28.0F, -1.0F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(0, 55).addBox(8.0F, -28.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(0, 50).addBox(3.0F, -28.0F, 0.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F))
                .texOffs(64, 22).addBox(4.0F, -28.0F, 0.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(64, 18).addBox(2.0F, -28.0F, 1.0F, 1.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(0, 16).addBox(1.0F, -28.0F, 3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 14).addBox(21.0F, -28.0F, -3.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(117, 50).addBox(25.0F, -28.0F, -18.0F, 1.0F, 1.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(88, 29).addBox(23.0F, -28.0F, -18.0F, 2.0F, 1.0F, 21.0F, new CubeDeformation(0.0F))
                .texOffs(0, 181).addBox(22.0F, -28.0F, -18.0F, 1.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(175, 129).addBox(21.0F, -28.0F, -18.0F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(22, 127).addBox(19.0F, -28.0F, -18.0F, 2.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(139, 51).addBox(18.0F, -28.0F, -18.0F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(109, 161).addBox(15.0F, -28.0F, -18.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(139, 32).addBox(7.0F, -28.0F, -18.0F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(156, 131).addBox(8.0F, -28.0F, -18.0F, 1.0F, 1.0F, 17.0F, new CubeDeformation(0.0F))
                .texOffs(136, 131).addBox(14.0F, -28.0F, -18.0F, 1.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(114, 121).addBox(13.0F, -28.0F, -18.0F, 1.0F, 1.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(98, 95).addBox(11.0F, -28.0F, -18.0F, 2.0F, 1.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(24, 100).addBox(4.0F, -28.0F, -18.0F, 3.0F, 1.0F, 19.0F, new CubeDeformation(0.0F))
                .texOffs(64, 29).addBox(-11.0F, -28.0F, -2.0F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(181, 91).addBox(-12.0F, -28.0F, -5.0F, 16.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(128, 141).addBox(-8.0F, -28.0F, -1.0F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 26).addBox(-6.0F, -28.0F, 0.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 30).addBox(-6.0F, -28.0F, 1.0F, 4.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 4).addBox(-8.0F, -28.0F, 1.0F, 2.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 79).addBox(-7.0F, -28.0F, 2.0F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 121).addBox(-14.0F, -28.0F, -7.0F, 18.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(187, 183).addBox(-12.0F, -28.0F, -8.0F, 16.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(180, 87).addBox(-14.0F, -28.0F, -11.0F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(178, 155).addBox(-16.0F, -28.0F, -12.0F, 20.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(176, 126).addBox(-17.0F, -28.0F, -13.0F, 21.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(181, 105).addBox(-13.0F, -28.0F, -14.0F, 17.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(187, 181).addBox(-12.0F, -28.0F, -16.0F, 16.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(180, 82).addBox(-14.0F, -28.0F, -17.0F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(178, 153).addBox(-16.0F, -28.0F, -18.0F, 20.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(162, 85).addBox(-18.0F, -28.0F, -19.0F, 22.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(142, 29).addBox(-19.0F, -28.0F, -21.0F, 23.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(179, 45).addBox(-14.0F, -28.0F, -22.0F, 18.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(178, 151).addBox(-16.0F, -28.0F, -23.0F, 20.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(176, 124).addBox(-17.0F, -28.0F, -24.0F, 21.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(146, 23).addBox(-19.0F, -28.0F, -25.0F, 23.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(142, 89).addBox(-20.0F, -28.0F, -26.0F, 24.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(64, 27).addBox(-21.0F, -28.0F, -27.0F, 25.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(154, 186).addBox(-19.0F, -28.0F, -28.0F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(122, 112).addBox(-10.0F, -28.0F, -15.0F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(121, 118).addBox(-10.0F, -28.0F, -9.0F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(163, 108).addBox(-9.0F, -28.0F, -10.0F, 13.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 77).addBox(9.0F, -28.0F, -18.0F, 2.0F, 1.0F, 21.0F, new CubeDeformation(0.0F))
                .texOffs(74, 92).addBox(17.0F, -28.0F, -18.0F, 1.0F, 1.0F, 21.0F, new CubeDeformation(0.0F))
                .texOffs(68, 68).addBox(16.0F, -28.0F, -18.0F, 1.0F, 1.0F, 22.0F, new CubeDeformation(0.0F))
                .texOffs(180, 68).addBox(32.0F, -28.0F, -18.0F, 1.0F, 1.0F, 13.0F, new CubeDeformation(0.0F))
                .texOffs(128, 168).addBox(36.0F, -28.0F, -18.0F, 1.0F, 1.0F, 15.0F, new CubeDeformation(0.0F))
                .texOffs(91, 160).addBox(35.0F, -28.0F, -18.0F, 1.0F, 1.0F, 16.0F, new CubeDeformation(0.0F))
                .texOffs(72, 177).addBox(37.0F, -28.0F, -18.0F, 1.0F, 1.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-40.0F, 4.0F, -14.0F));

        PartDefinition leg_left = eagle.addOrReplaceChild("leg_left", CubeListBuilder.create().texOffs(0, 121).addBox(-84.0F, -23.0F, -14.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(86.0F, 13.4F, 6.0F));

        PartDefinition cube_r2 = leg_left.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(192, 128).addBox(-3.0F, -2.0F, -6.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-80.0F, -12.0F, -5.0F, 0.48F, 0.0F, 0.0F));

        PartDefinition cube_r3 = leg_left.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(117, 51).addBox(-2.0F, -4.0F, -6.0F, 4.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-80.0F, -2.0F, -2.0F, -0.48F, 0.0F, 0.0F));

        PartDefinition feet = leg_left.addOrReplaceChild("feet", CubeListBuilder.create().texOffs(152, 0).addBox(-4.0F, -34.4292F, -33.8343F, 8.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(10, 90).addBox(2.0F, -33.4292F, -34.8343F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 55).addBox(2.0F, -33.4292F, -35.8343F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(6, 50).addBox(-1.0F, -33.4292F, -35.8343F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(0, 90).addBox(-1.0F, -33.4292F, -34.8343F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 20).addBox(-4.0F, -33.4292F, -35.8343F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(5, 88).addBox(-4.0F, -33.4292F, -34.8343F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-80.0F, 30.0F, 25.0F, 0.2618F, 0.0F, 0.0F));

        PartDefinition leg_right = eagle.addOrReplaceChild("leg_right", CubeListBuilder.create().texOffs(93, 116).addBox(-84.0F, -23.0F, -14.0F, 8.0F, 12.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(74.0F, 13.4F, 6.0F));

        PartDefinition cube_r4 = leg_right.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 100).addBox(-2.0F, -4.0F, -6.0F, 4.0F, 13.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-80.0F, -2.0F, -2.0F, -0.48F, 0.0F, 0.0F));

        PartDefinition cube_r5 = leg_right.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(136, 186).addBox(-3.0F, -2.0F, -6.0F, 6.0F, 8.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-80.0F, -12.0F, -5.0F, 0.48F, 0.0F, 0.0F));

        PartDefinition feet2 = leg_right.addOrReplaceChild("feet2", CubeListBuilder.create().texOffs(150, 150).addBox(-4.0F, -32.4292F, -33.8343F, 8.0F, 4.0F, 12.0F, new CubeDeformation(0.0F))
                .texOffs(83, 87).addBox(2.0F, -31.4292F, -34.8343F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(7, 14).addBox(2.0F, -31.4292F, -35.8343F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(77, 87).addBox(-1.0F, -31.4292F, -34.8343F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 7).addBox(-1.0F, -31.4292F, -35.8343F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(71, 87).addBox(-4.0F, -31.4292F, -34.8343F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(8, 0).addBox(-4.0F, -31.4292F, -35.8343F, 2.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-80.0F, 28.0F, 25.0F, 0.2618F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 224, 224);
    }

        @Override
        public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
            poseStack.pushPose();
            //  poseStack.scale(2.0f, 2.0f, 2.0f); // Увеличиваем масштаб модели
            eagle.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
            poseStack.popPose();        }

    @Override
    public ModelPart root() {
        return eagle;
    }
    @Override
    public void setupAnim(Eagle entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

            this.animate(entity.flyAnimationState, ModAnimationDefinitions.EAGLE_FLY, ageInTicks, 1f);
            // Применяем анимацию покоя
            this.animate(entity.idleAnimationState, ModAnimationDefinitions.EAGLE_IDLE, ageInTicks, 1f);

        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
    }

}
